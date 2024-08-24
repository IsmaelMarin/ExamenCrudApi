package com.examen.e_commerce.service;

import com.examen.e_commerce.model.Category;

import java.util.List;

public interface CategoryService {

    public Category create(Category category);

    public List<Category> getAllCategory();

    public Category getCategoryById(Integer id);

    public Category update(Category category);

    public String deleteCategory(Integer id);
}
