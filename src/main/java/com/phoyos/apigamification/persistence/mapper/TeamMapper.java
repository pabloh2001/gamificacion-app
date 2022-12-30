package com.phoyos.apigamification.persistence.mapper;

import com.phoyos.apigamification.domain.dto.Team;
import com.phoyos.apigamification.persistence.entity.Equipo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CourseMapper.class})
public interface TeamMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "cursoId", target = "courseId"),
            @Mapping(source = "estado", target = "state")
    })
    Team toTeam(Equipo equipo);
    List<Team> toTeams(List<Equipo> equipos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "curso", ignore = true),
            @Mapping(target = "usuarios", ignore = true)
    })
    Equipo toEquipo(Team team);
}
