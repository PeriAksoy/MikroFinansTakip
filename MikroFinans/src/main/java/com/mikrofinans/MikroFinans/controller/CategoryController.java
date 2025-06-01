package com.mikrofinans.MikroFinans.controller;

import com.mikrofinans.MikroFinans.model.Category;
import com.mikrofinans.MikroFinans.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //Kategori ekleme
    @PostMapping("/add")
    public Category createCategory(@Valid @RequestBody Category category) {
        return categoryService.addCategory(category);
    }
    //Tüm kategorileri listeleme
    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    //Id göre listeleme
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
    //Kategori silme
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
