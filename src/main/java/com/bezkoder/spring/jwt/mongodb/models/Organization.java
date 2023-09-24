package com.bezkoder.spring.jwt.mongodb.models;

import com.bezkoder.spring.jwt.mongodb.utils.Avatar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "organizations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "type")
    private String type;

    @Field(name = "location")
    private String location;

    @Field(name = "avatar")
    private Avatar avatar;

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