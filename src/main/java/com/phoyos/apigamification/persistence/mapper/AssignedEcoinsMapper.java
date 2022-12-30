package com.phoyos.apigamification.persistence.mapper;

import com.phoyos.apigamification.domain.dto.AssignedEcoins;
import com.phoyos.apigamification.persistence.entity.EcoinsAsignado;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AssignedEcoinsMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "usuarioId", target = "userId"),
            @Mapping(source = "valor", target = "total")
    })
    AssignedEcoins toAssignedEcoins(EcoinsAsignado ecoinsAsignado);
    List<AssignedEcoins> toAssignedEcoinsList(List<EcoinsAsignado> ecoinsAsignadoList);

    @InheritInverseConfiguration
    @Mapping(target = "usuario", ignore = true)
    EcoinsAsignado toEcoinsAsignado(AssignedEcoins assignedEcoins);
}
