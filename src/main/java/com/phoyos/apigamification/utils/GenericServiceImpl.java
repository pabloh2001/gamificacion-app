package com.phoyos.apigamification.utils;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {

    @Override
    public List<T> getAll() {
        return getRepository().getAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        return getRepository().get(id);
    }

    @Override
    public void deleteById(ID id) {
        getRepository().delete(id);
    }

    public abstract GenericRepository<T, ID> getRepository();

}
