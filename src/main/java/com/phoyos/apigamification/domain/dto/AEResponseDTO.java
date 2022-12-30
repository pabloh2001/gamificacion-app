package com.phoyos.apigamification.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AEResponseDTO {
    private String id;
    private String userId;
    private String completeName;
    private String team;
    private long total;
}
