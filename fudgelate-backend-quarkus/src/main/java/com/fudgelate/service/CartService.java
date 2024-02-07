package com.fudgelate.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.fudgelate.model.Cart;
import com.fudgelate.model.Product;
import com.fudgelate.repository.CartRepository;
import com.fudgelate.repository.ProductRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;

@ApplicationScoped
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    @PersistenceContext
    EntityManager em;

    @Inject
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Cart createCart(Cart cart) {
        try {
            List<Product> products = new ArrayList<>();
            for (Product product : cart.getProducts()) {
                System.out.println("Searching for product with ID: " + product.getProductId()); // Log the product ID
                                                                                                // being searched for
                Product existingProduct = productRepository.findById(product.getProductId());
                if (existingProduct != null) {
                    existingProduct.setQuantity(product.getQuantity());
                    products.add(existingProduct);
                } else {
                    // Skip the product if it does not exist
                    System.err.println("Product with ID " + product.getProductId() + " not found");
                }
            }

            cart.setProducts(products);

            cartRepository.persist(cart);
            return cart;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id);
    }

    @Transactional
    public Cart updateCart(Long id, Cart newCart) {
        Cart cart = cartRepository.findById(id);
        if (cart != null) {
            List<Product> existingProducts = cart.getProducts();
            existingProducts.clear();
            for (Product product : newCart.getProducts()) {
                if (product.getPrice() == null || product.getInventoryCount() == null || product.getName() == null
                        || product.getName().isEmpty()) {
                    throw new ConstraintViolationException("Product validation failed", new HashSet<>());
                }
                if (product.getId() == null) {
                    productRepository.persist(product);
                } else {
                    em.merge(product);
                }
                existingProducts.add(product);
            }
        }
        cartRepository.persist(cart);
        return cart;
    }

    @Transactional
    public boolean deleteCart(Long id) {
        Cart cart = cartRepository.findById(id);
        if (cart != null) {
            cartRepository.delete(cart);
            return true;
        } else {
            return false;
        }
    }

}