package com.examen.e_commerce.service.impl;

import com.examen.e_commerce.model.Order;
import com.examen.e_commerce.repository.OrderRepository;
import com.examen.e_commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public String deleteOrder(Integer id) {
        orderRepository.deleteById(id);
        return "Record " + id + " Deleted";
    }
}
