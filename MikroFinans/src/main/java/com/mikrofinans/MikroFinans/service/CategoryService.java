package com.mikrofinans.MikroFinans.service;

import com.mikrofinans.MikroFinans.model.Category;
import com.mikrofinans.MikroFinans.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    //Category ekleme
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    //Category listeleme
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    //İd göre listeleme
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
    //Category silme
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
