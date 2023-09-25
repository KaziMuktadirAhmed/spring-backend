package com.bezkoder.spring.jwt.mongodb.models;

import com.bezkoder.spring.jwt.mongodb.utils.Avatar;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "organizations")
@Data
@NoArgsConstructor
public class Organization {
    @Id
    private String id;

    @JsonProperty("name")
    @Field(name = "name")
    private String name;

    @JsonProperty("type")
    @Field(name = "type")
    private String type;

    @JsonProperty("location")
    @Field(name = "location")
    private String location;

    @JsonProperty("avatar")
    @Field(name = "avatar")
    private Avatar avatar;

    @JsonProperty("phone")
    @Field(name = "phone")
    private String phone;

    public Organization(String id, String name, String type, String location, String phone) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", avatar=" + avatar +
                ", phone='" + phone + '\'' +
                '}';
    }
}