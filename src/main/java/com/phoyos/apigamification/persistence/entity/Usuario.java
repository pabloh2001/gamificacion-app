package com.phoyos.apigamification.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    @Column(name = "password")
    private String contrasena;
    @Transient
    private String confirmarPass;
    @Column(name = "equipos_id")
    private String equipoId;
    @Column(name = "roles_id")
    private String rolId;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "equipos_id", insertable = false, updatable = false)
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "roles_id", insertable = false, updatable = false)
    private Rol rol;
}
