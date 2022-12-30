package com.phoyos.apigamification.domain.domrepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID extends Serializable> {
    List<T> getAll();
    Optional<T> get(ID id);
    T save(T entity);
    void delete(ID id);
}
