package com.phoyos.apigamification.controller.rest;

import com.phoyos.apigamification.domain.dto.Category;
import com.phoyos.apigamification.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> categories(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Category> category(@PathVariable("id") String id){
        return categoryService.getById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
