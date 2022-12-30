package com.phoyos.apigamification.domain.service.impl;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Course;
import com.phoyos.apigamification.domain.service.CourseService;
import com.phoyos.apigamification.persistence.repository.CursoRepository;
import com.phoyos.apigamification.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends GenericServiceImpl<Course, String> implements CourseService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public GenericRepository<Course, String> getRepository() {
        return cursoRepository;
    }

    @Override
    public Course save(Course course) {
        return cursoRepository.save(course);
    }
}
