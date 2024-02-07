package com.fudgelate.service;

import java.util.List;

import com.fudgelate.model.Product;
import com.fudgelate.repository.ProductRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProductService {

    private final ProductRepository productRepository;

    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.listAll();
    }

    @Transactional
    public Product addProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product updateProduct(Long id, Product newProduct) {
        Product product = productRepository.findById(id);
        if (product != null) {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            product.setInventoryCount(newProduct.getInventoryCount());
            product.setDescription(newProduct.getDescription());
            product.setCategory(newProduct.getCategory());
            product.setImageUrl(newProduct.getImageUrl());
            product.setWeight(newProduct.getWeight());
            product.setDimensions(newProduct.getDimensions());
            product.setReleaseDate(newProduct.getReleaseDate());
            product.setDiscountedPrice(newProduct.getDiscountedPrice());
            productRepository.persist(product);
        }
        return product;
    }

    @Transactional
    public boolean deleteProduct(Long id) {
        Product product = productRepository.findById(id);
        if (product != null) {
            productRepository.delete(product);
            return true;
        } else {
            return false;
        }
    }

}