package com.phoyos.apigamification.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class User {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
    private String teamId;
    private String roleId = "3194ea63-57ed-11ed-94b0-14cb19cffa7e";
    private boolean state;
    private Team team;
    private Role role;
}
