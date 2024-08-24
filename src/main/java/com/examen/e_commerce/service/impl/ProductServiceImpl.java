package com.examen.e_commerce.service.impl;

import com.examen.e_commerce.model.Product;
import com.examen.e_commerce.repository.ProductRepository;
import com.examen.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "Record " + id + " Deleted";
    }
}