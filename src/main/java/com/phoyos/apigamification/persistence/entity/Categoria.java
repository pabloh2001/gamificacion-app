package com.phoyos.apigamification.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    private String id;
    private String descripcion;
    private Long valor;
    private Boolean estado;
}
