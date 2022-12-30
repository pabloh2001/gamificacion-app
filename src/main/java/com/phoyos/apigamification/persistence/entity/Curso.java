package com.phoyos.apigamification.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    private String id;
    private String nombre;
    private Boolean estado;

    @OneToMany(mappedBy = "curso")
    private List<Equipo> equipos;
}
