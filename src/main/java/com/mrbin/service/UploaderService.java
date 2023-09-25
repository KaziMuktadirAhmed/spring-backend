package com.bezkoder.spring.jwt.mongodb.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UploaderService {

    @Value("${Mr.Bin.Cloudinary.Api.Secrate}")
    private String cloudinaryApiSecrate;

    @Value("${Mr.Bin.Cloudinary.Api.Key}")
    private String cloudinaryApiKey;

    @Value("${Mr.Bin.Cloudinary.Api.CloudName}")
    private String coludinaryCloudName;

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", coludinaryCloudName,
            "api_key", cloudinaryApiKey,
            "api_secret", cloudinaryApiSecrate
    ));

    // Define the upload preset name (you should create this preset in your Cloudinary dashboard)
    String uploadPreset = "your_upload_preset_name";

    // Calculate the expiration time (e.g., 1 hour from now)
    long expirationTimeMillis = System.currentTimeMillis() + (60 * 60 * 1000); // 1 hour in milliseconds

    // Convert the expiration time to a Date object
    Date expirationDate = new Date(expirationTimeMillis);


    public String getUploadUrl() {
        
        return "";
    }
}
