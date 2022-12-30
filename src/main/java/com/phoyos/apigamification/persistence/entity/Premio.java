package com.phoyos.apigamification.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "premios")
public class Premio {
    @Id
    private String id;
    private String nombre;
    private Long valor;
}
