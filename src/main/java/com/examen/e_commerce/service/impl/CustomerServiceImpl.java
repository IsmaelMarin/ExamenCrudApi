package com.examen.e_commerce.service.impl;

import com.examen.e_commerce.model.Customer;
import com.examen.e_commerce.repository.CustomerRepository;
import com.examen.e_commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "Record " + id + " Deleted";
    }
}