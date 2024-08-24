package com.examen.e_commerce.service;

import com.examen.e_commerce.model.Product;

import java.util.List;

public interface ProductService {


    public Product create(Product product);

    public List<Product> getAllProducts();

    public Product getProductById(Integer id);

    public Product update(Product product);

    public String deleteProduct(Integer id);
}
