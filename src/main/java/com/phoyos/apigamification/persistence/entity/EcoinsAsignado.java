package com.phoyos.apigamification.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ecoins_asignados")
public class EcoinsAsignado {
    @Id
    private String id;
    @Column(name = "usuarios_id")
    private String usuarioId;
    private Long valor;

    @ManyToOne()
    @JoinColumn(name = "usuarios_id", insertable = false, updatable = false)
    private Usuario usuario;

}
