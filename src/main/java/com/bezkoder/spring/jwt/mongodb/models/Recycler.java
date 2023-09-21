package com.bezkoder.spring.jwt.mongodb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "recyclers")
public class Recycler {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "company")
    private String company;

    @Field(name = "location")
    private String location;

//    @Field(name = "avatar")
//    private Avatar avatar;

    @Field(name = "phone")
    private String phone;

    public Recycler(String name, String company, String location, String phone) {
        this.name = name;
        this.company = company;
        this.location = location;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Recycler{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
//                ", avatar=" + avatar +
                ", phone='" + phone + '\'' +
                '}';
    }
}
