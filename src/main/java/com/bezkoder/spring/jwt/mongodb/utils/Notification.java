package com.bezkoder.spring.jwt.mongodb.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Notification {

    private String description;
    private String link;

}
