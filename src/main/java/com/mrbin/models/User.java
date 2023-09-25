package com.mrbin.models;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mrbin.utils.Address;
import com.mrbin.utils.Avatar;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import com.mrbin.utils.Comment;
@Document(collection = "users")
@Getter
@Setter
public class User {
  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @Field(name = "isVerified")
  private Boolean isVerified = false;

  @Field(name = "address")
  private Address address;

  @Indexed(unique = true)
  @Field(name = "phone")
  private String phone;

  @Field(name = "favorites")
  private List<String> favorites;

  @Field(name = "avatar")
  private Avatar avatar;

  @Field(name = "createdAt")
  private Date createdAt = new Date();

  @Field(name = "resetPasswordToken")
  private String resetPasswordToken;

  @Field(name = "resetPasswordExpire")
  private Date resetPasswordExpire;

  @DBRef
  private Set<Role> roles = new HashSet<>();

  public User() {
  }

  public User(String username, String email, String password, String phone) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.phone = phone;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
}
