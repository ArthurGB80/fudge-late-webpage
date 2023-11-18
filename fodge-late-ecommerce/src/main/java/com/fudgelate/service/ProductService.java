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

    public void addProduct(Product product) {
        productRepository.persist(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public void updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId());
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            productRepository.persist(existingProduct);
        }
    }

    // Remove this method if ProductRepository doesn't have a search method
    // public List<Product> searchProducts(String keyword) {
    //     return productRepository.search(keyword);
    // }
}