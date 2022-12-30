package com.phoyos.apigamification.domain.service;

import com.phoyos.apigamification.domain.dto.Course;
import com.phoyos.apigamification.utils.GenericServiceAPI;

public interface CourseService extends GenericServiceAPI<Course,String> {

    Course save(Course course);
}
