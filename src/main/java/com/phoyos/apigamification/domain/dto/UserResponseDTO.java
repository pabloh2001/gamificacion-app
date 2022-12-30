package com.phoyos.apigamification.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class UserResponseDTO {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String team;
}
