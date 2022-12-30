package com.phoyos.apigamification.persistence.dao;

import com.phoyos.apigamification.persistence.entity.EcoinsAsignado;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EcoinsAsignadoCrudRepo extends CrudRepository<EcoinsAsignado, String> {

    @Query(value = "SELECT * FROM ecoins_asignados WHERE usuarios_id = :id", nativeQuery = true)
    Optional<EcoinsAsignado> getByUsuario(@Param("id") String id);
    @Transactional
    @Modifying
    @Query(value = "UPDATE ecoins_asignados SET valor = valor + :value WHERE id = :id", nativeQuery = true)
    void assignEcoin(@Param("value") Long value, @Param("id") String id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ecoins_asignados SET valor = valor - :value WHERE usuarios_id = :id", nativeQuery = true)
    void subtractEcoin(@Param("value") Long value, @Param("id") String id);

}
