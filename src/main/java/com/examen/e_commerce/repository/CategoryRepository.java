package com.examen.e_commerce.repository;

import com.examen.e_commerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
