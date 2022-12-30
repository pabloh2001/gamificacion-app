package com.phoyos.apigamification.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Category {
    private String id = UUID.randomUUID().toString();
    private String description;
    private long value;
    private boolean state;
}
