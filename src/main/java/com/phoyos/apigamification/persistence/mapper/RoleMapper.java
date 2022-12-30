package com.phoyos.apigamification.persistence.mapper;

import com.phoyos.apigamification.domain.dto.Role;
import com.phoyos.apigamification.persistence.entity.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name")
    })
    Role toRole(Rol rol);
    List<Role> toRoles(List<Rol> roles);

    @InheritInverseConfiguration
    Rol toRol(Role role);
}
