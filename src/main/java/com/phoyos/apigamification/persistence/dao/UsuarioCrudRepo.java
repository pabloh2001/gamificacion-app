package com.phoyos.apigamification.persistence.dao;

import com.phoyos.apigamification.persistence.projections.DashboardDTOu;
import com.phoyos.apigamification.persistence.entity.Usuario;
import com.phoyos.apigamification.persistence.projections.HomeUsersDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepo extends CrudRepository<Usuario,String> {

    Optional<Usuario> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE usuarios " +
            "SET nombre = :nombre, apellido = :apellido, email = :email, equipos_id = :equipoId " +
            "WHERE id = :id", nativeQuery = true)
    void edit(@Param("id") String id, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("email") String email, @Param("equipoId") String equipoId);

    @Query(value = "SELECT u.nombre as name, u.apellido as lastName, t.nombre as team, e.valor as value\n" +
            "FROM usuarios u " +
            "INNER JOIN ecoins_asignados e ON u.id = e.usuarios_id\n" +
            "INNER JOIN equipos t ON u.equipos_id = t.id\n" +
            "ORDER BY e.valor DESC LIMIT 5", nativeQuery = true)
    List<DashboardDTOu> studensRaking();

    @Query(value = "SELECT u.nombre as name, u.apellido as lastName, t.id as team, e.valor as value\n" +
            "FROM usuarios u " +
            "INNER JOIN ecoins_asignados e ON u.id = e.usuarios_id\n" +
            "INNER JOIN equipos t ON u.equipos_id = t.id\n" +
            "WHERE t.id = :teamId\n" +
            "ORDER BY e.valor DESC", nativeQuery = true)
    List<HomeUsersDTO> studentsTeam(@Param("teamId") String teamId);

}
