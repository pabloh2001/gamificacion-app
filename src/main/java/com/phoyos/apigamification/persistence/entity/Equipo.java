package com.phoyos.apigamification.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    private String id;
    private String nombre;
    @Column(name = "cursos_id")
    private String cursoId;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "cursos_id", insertable = false, updatable = false)
    private Curso curso;

    @OneToMany(mappedBy = "equipo")
    List<Usuario> usuarios;
}
