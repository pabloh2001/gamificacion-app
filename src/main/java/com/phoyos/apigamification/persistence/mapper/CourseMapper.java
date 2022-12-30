package com.phoyos.apigamification.persistence.mapper;

import com.phoyos.apigamification.domain.dto.Course;
import com.phoyos.apigamification.persistence.entity.Curso;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TeamMapper.class})
public interface CourseMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "equipos", target = "teams")
    })
    Course toCourse(Curso curso);
    List<Course> toCourses(List<Curso> cursos);

    @InheritInverseConfiguration
    Curso toCurso(Course course);
}
