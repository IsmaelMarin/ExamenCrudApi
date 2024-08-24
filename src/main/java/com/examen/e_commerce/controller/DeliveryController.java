package com.examen.e_commerce.controller;

import com.examen.e_commerce.error.MensajesError;
import com.examen.e_commerce.model.Delivery;
import com.examen.e_commerce.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("")
    public List<Delivery> getDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delivery> getDelivery(@PathVariable Integer id) {
        Delivery delivery = deliveryService.getDeliveryById(id);
        if (delivery != null) {
            return new ResponseEntity<>(delivery, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/store")
    public ResponseEntity<MensajesError> saveDelivery(@Valid @RequestBody Delivery delivery, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new MensajesError(null, bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        } else {
            deliveryService.create(delivery);
            return new ResponseEntity<>(new MensajesError(delivery, "Delivery created successfully"), HttpStatus.CREATED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Delivery> updateDelivery(@Valid @RequestBody Delivery delivery) {
        Delivery updatedDelivery = deliveryService.update(delivery);
        return new ResponseEntity<>(updatedDelivery, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDelivery(@PathVariable Integer id) {
        String response = deliveryService.deleteDelivery(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
