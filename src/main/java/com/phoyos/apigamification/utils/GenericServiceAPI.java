package com.phoyos.apigamification.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericServiceAPI<T, ID extends Serializable> {
    List<T> getAll();
    Optional<T> getById(ID id);

    void deleteById(ID id);
}
