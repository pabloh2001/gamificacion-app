package com.phoyos.apigamification.persistence.repository;

import com.phoyos.apigamification.domain.domrepository.GenericRepository;
import com.phoyos.apigamification.domain.dto.Category;
import com.phoyos.apigamification.persistence.dao.CategoriaCrudRepo;
import com.phoyos.apigamification.persistence.entity.Categoria;
import com.phoyos.apigamification.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements GenericRepository<Category, String> {

    @Autowired
    private CategoriaCrudRepo categoriaCrudRepo;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepo.findAll();
        return categoryMapper.toCategories(categorias);
    }

    @Override
    public Optional<Category> get(String s) {
        return categoriaCrudRepo.findById(s).map(categoria -> categoryMapper.toCategory(categoria));
    }

    @Override
    public Category save(Category entity) {
        Categoria categoria = categoryMapper.toCategoria(entity);
        return categoryMapper.toCategory(categoriaCrudRepo.save(categoria));
    }

    @Override
    public void delete(String s) {
        categoriaCrudRepo.deleteById(s);
    }
}
