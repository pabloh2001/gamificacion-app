package com.phoyos.apigamification.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class DashboardDTO {
    private String row;
    private String name;
    private String lastName;
    private long value;
}
