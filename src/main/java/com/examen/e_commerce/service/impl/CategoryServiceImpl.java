package com.examen.e_commerce.service.impl;

import com.examen.e_commerce.model.Category;
import com.examen.e_commerce.repository.CategoryRepository;
import com.examen.e_commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();  //Este método findAll extiendo de la interfaz jpa
    }

    @Override
    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return "Record " + id + " Deleted";
    }
}
