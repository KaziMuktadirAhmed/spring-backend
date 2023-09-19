package com.bezkoder.spring.jwt.mongodb.models.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {

    private String description;
    private String link;

}
