package com.examen.e_commerce.repository;

import com.examen.e_commerce.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {
}
