package com.examen.e_commerce.controller;

import com.examen.e_commerce.error.MensajesError;
import com.examen.e_commerce.model.Customer;
import com.examen.e_commerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/store")
    public ResponseEntity<MensajesError> saveCustomer(@Valid @RequestBody Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new MensajesError(null, bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        } else {
            customerService.create(customer);
            return new ResponseEntity<>(new MensajesError(customer, "Customer created successfully"), HttpStatus.CREATED);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.update(customer);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        String response = customerService.deleteCustomer(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}