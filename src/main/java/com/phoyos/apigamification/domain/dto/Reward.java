package com.phoyos.apigamification.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Reward {
    private String id = UUID.randomUUID().toString();
    private String name;
    private long value;
}
