package com.phoyos.apigamification.domain.service;

import com.phoyos.apigamification.domain.dto.Category;
import com.phoyos.apigamification.utils.GenericServiceAPI;

public interface CategoryService extends GenericServiceAPI<Category, String> {

    Category save(Category category);
}
