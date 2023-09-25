package com.mrbin.controllers;

import com.mrbin.service.UploaderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UploadFileController {

    @Autowired
    private UploaderService uploaderService;

    @GetMapping("/test-upload")
    public ResponseEntity<String> testUpload() {
        String signStr =  uploaderService.getUploadUrl();
        return new ResponseEntity(signStr, HttpStatus.OK);
    }
}
