package com.phoyos.apigamification.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
public class SpendEcoins {
    private String id = UUID.randomUUID().toString();
    private String userId;
    private String rewardId;
}
