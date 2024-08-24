package com.examen.e_commerce.controller;

import com.examen.e_commerce.error.MensajesError;
import com.examen.e_commerce.model.Order;
import com.examen.e_commerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Integer id) {
        Order order = orderService.getOrderById(id);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/store")
    public ResponseEntity<MensajesError> saveOrder(@Valid @RequestBody Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new MensajesError(null, bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        } else {
            orderService.create(order);
            return new ResponseEntity<>(new MensajesError(order, "Order created successfully"), HttpStatus.CREATED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@Valid @RequestBody Order order) {
        Order updatedOrder = orderService.update(order);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer id) {
        String response = orderService.deleteOrder(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
