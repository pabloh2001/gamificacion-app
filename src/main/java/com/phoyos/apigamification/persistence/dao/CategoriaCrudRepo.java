package com.phoyos.apigamification.persistence.dao;

import com.phoyos.apigamification.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaCrudRepo extends CrudRepository<Categoria, String> {
}
