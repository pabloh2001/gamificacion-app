package com.phoyos.apigamification.persistence.dao;

import com.phoyos.apigamification.persistence.entity.Equipo;
import com.phoyos.apigamification.persistence.projections.DashboardDTOt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EquipoCrudRepo extends CrudRepository<Equipo, String> {

    @Query(value = "SELECT c.nombre as name, SUM(e.valor) as value " +
            "FROM ecoins_asignados e " +
            "JOIN usuarios u ON e.usuarios_id = u.id " +
            "JOIN equipos c ON u.equipos_id = c.id " +
            "GROUP BY c.nombre LIMIT 5", nativeQuery = true)
    List<DashboardDTOt> teamsRanking();
}
