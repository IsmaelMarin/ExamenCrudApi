package com.examen.e_commerce.repository;

import com.examen.e_commerce.model.Order;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
