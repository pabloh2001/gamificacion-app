package com.phoyos.apigamification.persistence.dao;

import com.phoyos.apigamification.persistence.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoCrudRepo extends CrudRepository<Curso, String> {
}
