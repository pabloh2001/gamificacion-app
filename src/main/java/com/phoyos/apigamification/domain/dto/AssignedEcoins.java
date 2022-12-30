package com.phoyos.apigamification.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class AssignedEcoins {
    private String id = UUID.randomUUID().toString();
    private String userId;
    private long total;
}
