package com.fudgelate.service;

import com.fudgelate.model.Product;
import com.fudgelate.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;



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

    public Product addProduct(Product product) {
        productRepository.persist(product);
        return product;
    }

    public void updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId());
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            productRepository.persist(existingProduct);
        }
    }
    public Product getProduct(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product newProduct) {
        Product product = productRepository.findById(id);
        if (product != null) {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            // set other fields 
            productRepository.persist(product);
        }
        return product;
    }
    
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