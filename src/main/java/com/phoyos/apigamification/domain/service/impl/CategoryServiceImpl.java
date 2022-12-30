package com.phoyos.apigamification.domain.service.impl;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Category;
import com.phoyos.apigamification.domain.service.CategoryService;
import com.phoyos.apigamification.persistence.repository.CategoriaRepository;
import com.phoyos.apigamification.utils.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category,String> implements CategoryService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public GenericRepository<Category, String> getRepository() {
        return categoriaRepository;
    }

    @Override
    public Category save(Category category) {
        return categoriaRepository.save(category);
    }
}
