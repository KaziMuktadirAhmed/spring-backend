package com.bezkoder.spring.jwt.mongodb.models.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avatar {
    private String publicId;
    private String url;
}
