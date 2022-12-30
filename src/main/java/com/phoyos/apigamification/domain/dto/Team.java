package com.phoyos.apigamification.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Team {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String courseId;
    private boolean state;
}
