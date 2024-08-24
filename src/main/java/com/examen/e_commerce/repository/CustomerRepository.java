package com.examen.e_commerce.repository;

import com.examen.e_commerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
