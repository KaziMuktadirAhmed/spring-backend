package com.mrbin.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Configuration;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UploaderService {

    @Value("${Mr.Bin.Cloudinary.Api.Secrate}")
    private String cloudinaryApiSecrate;

    @Value("${Mr.Bin.Cloudinary.Api.Key}")
    private String cloudinaryApiKey;

    @Value("${Mr.Bin.Cloudinary.Api.CloudName}")
    private String coludinaryCloudName;

    Configuration config = new Configuration();

    public UploaderService() {
        config.cloudName = coludinaryCloudName;
        config.apiKey = cloudinaryApiKey;
        config.apiSecret = cloudinaryApiSecrate;
    }

    private Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "dljep9qgw",
            "api_key", "485977825684594",
            "api_secret", "SHtqSwkkWr8U-i2UBHN-AhDbo4w"
    ));

    // Calculate the expiration time (e.g., 1 hour from now)
    long expirationTimeMillis = System.currentTimeMillis() + (24 * 60 * 60 * 1000); // 1 hour in milliseconds

    // Convert the expiration time to a Date object
    Date expirationDate = new Date(expirationTimeMillis);


    public String getUploadUrl() {


// Set the parameters for your upload
        String resourceType = "image"; // Replace with your desired resource type
        long expirationInSeconds = 3600; // Replace with the expiration time (in seconds)
        long timestamp = System.currentTimeMillis() / 1000 + expirationInSeconds;

        // Construct a Map with the parameters
        Map<String, Object> params = new HashMap<>();
        params.put("timestamp", timestamp);

        String cloudSign = cloudinary.apiSignRequest(params, cloudinaryApiSecrate);

        System.out.println("sign: " + cloudSign + " timestamp: " + timestamp);
        System.out.println(cloudinaryApiKey + " " + cloudinaryApiSecrate + " " +  coludinaryCloudName);

        return "sign: " + cloudSign + " timestamp: " + timestamp;
    }
}
