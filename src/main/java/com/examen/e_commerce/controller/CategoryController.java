package com.examen.e_commerce.controller;

import com.examen.e_commerce.error.MensajesError;
import com.examen.e_commerce.model.Category;
import com.examen.e_commerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> getCategories() {
        return categoryService.getAllCategory();
    }

    /*
    //Obtener un id especifico
    @GetMapping("/{id}")
    public Category getStudent(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    } */


    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/store")
    public ResponseEntity<MensajesError> saveCategory(@Valid @RequestBody Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new MensajesError(null, bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        } else {
            categoryService.create(category);
            return new ResponseEntity<>(new MensajesError(category, "Category created successfully"), HttpStatus.CREATED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) {
        Category updatedCategory = categoryService.update(category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        String response = categoryService.deleteCategory(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}