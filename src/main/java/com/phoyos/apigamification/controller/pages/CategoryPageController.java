package com.phoyos.apigamification.controller.pages;

import com.phoyos.apigamification.domain.dto.Category;
import com.phoyos.apigamification.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryPageController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin/categories")
    public String contextCategories(Model model){
        model.addAttribute("categories", categoryService.getAll());
        return "category";
    }

    @GetMapping("/admin/categories/create")
    public String createCategory(Model model){
        model.addAttribute("category", new Category());
        return "save-category";
    }

    @GetMapping("/admin/categories/edit/{id}")
    public String editCategory(@PathVariable("id") String id, Model model){
        model.addAttribute("category", categoryService.getById(id));
        return "save-category";
    }

    @PostMapping("/admin/categories/save")
    public String saveCategory(@Validated @ModelAttribute Category category, Model model){
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") String id){
        categoryService.deleteById(id);
        return "redirect:/admin/categories";
    }
}
