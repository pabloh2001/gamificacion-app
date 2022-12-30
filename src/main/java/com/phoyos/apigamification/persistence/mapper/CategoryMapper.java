package com.phoyos.apigamification.persistence.mapper;

import com.phoyos.apigamification.domain.dto.Category;
import com.phoyos.apigamification.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "valor", target = "value"),
            @Mapping(source = "estado", target = "state")
    })
    Category toCategory(Categoria categoria);
    List<Category> toCategories(List<Categoria> categorias);

    @InheritInverseConfiguration
    Categoria toCategoria(Category category);
}
