package com.phoyos.apigamification.domain.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Role {
    private String id = UUID.randomUUID().toString();
    private String name;
}
