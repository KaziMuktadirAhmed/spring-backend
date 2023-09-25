package com.mrbin.controllers;

import com.mrbin.payload.response.FileUploaderResponse;
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

    @GetMapping("/upload")
    public ResponseEntity<FileUploaderResponse> sendFileUploadPermission() {
        FileUploaderResponse response =  uploaderService.getUploadSignature();
        return new ResponseEntity<> (response, HttpStatus.OK);
    }
}
