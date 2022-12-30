package com.phoyos.apigamification.persistence.repository;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Course;
import com.phoyos.apigamification.persistence.dao.CursoCrudRepo;
import com.phoyos.apigamification.persistence.entity.Curso;
import com.phoyos.apigamification.persistence.mapper.CourseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Slf4j
@Repository
public class CursoRepository implements GenericRepository<Course,String> {

    @Autowired
    private CursoCrudRepo cursoCrudRepo;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAll() {
        List<Curso> cursos = (List<Curso>) cursoCrudRepo.findAll();
        List<Course> courses = courseMapper.toCourses(cursos);
        return courses;
    }

    @Override
    public Optional<Course> get(String s) {
        return cursoCrudRepo.findById(s).map(curso -> courseMapper.toCourse(curso));
    }

    @Override
    public Course save(Course entity) {
        Curso curso = courseMapper.toCurso(entity);
        return courseMapper.toCourse(cursoCrudRepo.save(curso));
    }

    @Override
    public void delete(String s) {
        cursoCrudRepo.deleteById(s);
    }
}
