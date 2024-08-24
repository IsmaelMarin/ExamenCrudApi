package com.examen.e_commerce.service;

import com.examen.e_commerce.model.Order;

import java.util.List;

public interface OrderService {

    public Order create(Order order);

    public List<Order> getAllOrders();

    public Order getOrderById(Integer id);

    public Order update(Order order);

    public String deleteOrder(Integer id);
}
