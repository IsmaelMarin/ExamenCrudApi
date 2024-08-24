package com.examen.e_commerce.service.impl;

import com.examen.e_commerce.model.Delivery;
import com.examen.e_commerce.repository.DeliveryRepository;
import com.examen.e_commerce.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public Delivery create(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery getDeliveryById(Integer id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public Delivery update(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public String deleteDelivery(Integer id) {
        deliveryRepository.deleteById(id);
        return "Record " + id + " Deleted";
    }
}