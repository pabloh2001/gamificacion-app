package com.phoyos.apigamification.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ecoins_canjeados", schema = "db_gamificacion")
public class EcoinsGastado {
    @Id
    private String id;
    @Column(name = "usuarios_id")
    private String usuarioId;
    @Column(name = "premios_id")
    private String premioId;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "premios_id", insertable = false, updatable = false)
    private Premio premio;
}
