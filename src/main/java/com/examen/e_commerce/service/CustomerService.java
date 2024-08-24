package com.examen.e_commerce.service;

import com.examen.e_commerce.model.Customer;

import java.util.List;

public interface CustomerService {


    public Customer create(Customer customer);

    public List<Customer> getAllCustomers();

    public Customer getCustomerById(Integer id);

    public Customer update(Customer customer);

    public String deleteCustomer(Integer id);
}
