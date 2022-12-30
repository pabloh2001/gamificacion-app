package com.phoyos.apigamification.persistence.dao;

import com.phoyos.apigamification.persistence.entity.EcoinsAsignado;
import com.phoyos.apigamification.persistence.entity.EcoinsGastado;
import com.phoyos.apigamification.persistence.projections.HistoryRedeemed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EcoinsGastadoCrudRepo extends CrudRepository<EcoinsGastado, String> {

    @Query(value = "SELECT p.nombre as reward, p.valor as value, ec.fecha as date FROM ecoins_canjeados ec \n" +
            "JOIN usuarios u ON u.id = ec.usuarios_id\n" +
            "JOIN equipos e ON e.id = u.equipos_id\n" +
            "JOIN premios p ON p.id = ec.premios_id\n" +
            "WHERE u.id = :userId\n" +
            "ORDER BY ec.fecha DESC;", nativeQuery = true)
    List<HistoryRedeemed> seeHistory(@Param("userId") String userId);

    @Query(value = "SELECT * FROM ecoins_canjeados WHERE usuarios_id = :id", nativeQuery = true)
    Optional<EcoinsGastado> getByUsuario(@Param("id") String id);
}
