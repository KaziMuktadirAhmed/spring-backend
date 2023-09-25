package com.mrbin.service;

import com.cloudinary.Cloudinary;
import com.mrbin.payload.response.FileUploaderResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UploaderService {

    @Value("${Mr.Bin.Cloudinary.Api.Secrate}")
    private String cloudinaryApiSecrete;

    @Value("${Mr.Bin.Cloudinary.Api.Key}")
    private String cloudinaryApiKey;

    @Value("${Mr.Bin.Cloudinary.Api.CloudName}")
    private String cloudinaryCloudName;


    public FileUploaderResponse getUploadSignature() {
        Cloudinary cloudinary = new Cloudinary(Map.of(
                "cloud_name", cloudinaryCloudName,
                "api_key", cloudinaryApiKey,
                "api_secret", cloudinaryApiSecrete
        ));

        long expirationInSeconds = 5; // Replace with the expiration time (in seconds)
        long timestamp = System.currentTimeMillis() / 1000 + expirationInSeconds;

        Map<String, Object> params = new HashMap<>();
        params.put("timestamp", String.valueOf(timestamp));

        String cloudSign = cloudinary.apiSignRequest(params, cloudinaryApiSecrete);

        return new FileUploaderResponse(timestamp, cloudSign);
    }
}
