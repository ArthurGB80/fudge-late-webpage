package com.fudgelate.service;

import java.util.List;


import com.fudgelate.model.Product;
import com.fudgelate.repository.ProductRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.listAll();
    }

    // Add more methods as needed...
}