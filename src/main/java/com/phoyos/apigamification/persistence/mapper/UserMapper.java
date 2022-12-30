package com.phoyos.apigamification.persistence.mapper;

import com.phoyos.apigamification.domain.dto.User;
import com.phoyos.apigamification.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellido", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "contrasena", target = "password"),
            @Mapping(source = "confirmarPass", target = "confirmPassword"),
            @Mapping(source = "equipoId", target = "teamId"),
            @Mapping(source = "rolId", target = "roleId"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "equipo", target = "team"),
            @Mapping(source = "rol", target = "role")
    })
    User toUser(Usuario usuario);
    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration
    Usuario toUsuario(User user);

}
