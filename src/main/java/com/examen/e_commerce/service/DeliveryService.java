package com.examen.e_commerce.service;

import com.examen.e_commerce.model.Delivery;

import java.util.List;

public interface DeliveryService {

    public Delivery create(Delivery delivery);

    public List<Delivery> getAllDeliveries();

    public Delivery getDeliveryById(Integer id);

    public Delivery update(Delivery delivery);

    public String deleteDelivery(Integer id);
}
