package com.fudgelate.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import com.fudgelate.model.Cart;
import com.fudgelate.model.Product;
import com.fudgelate.model.User;
import com.fudgelate.repository.CartRepository;
import com.fudgelate.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CartService {

    @Inject
    CartRepository cartRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    EntityManager entityManager;

    @Transactional
    public Cart createCartForUser(Long userId) {
        // Retrieve the user
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found for userId: " + userId);
        }

        // Create a new Cart entity
        Cart cart = new Cart();
        cart.setUser(user);

        // Save the cart to the database
        cartRepository.persist(cart);

        return cart;
    }

    @Transactional
    public Cart getCart(Long id) {
        return entityManager.find(Cart.class, id);
    }

    @Transactional
    public Cart updateCart(Long userId, Cart newCart) {
        // Find the user by ID
        User user = userRepository.findById(userId);
        if (user == null) {
            // Handle the case where the user does not exist
            throw new IllegalArgumentException("User not found for userId: " + userId);
        }

        // Get the user's existing cart
        Cart existingCart = user.getCart();
        if (existingCart == null) {
            // Handle the case where the user does not have a cart
            throw new IllegalArgumentException("User does not have a cart for userId: " + userId);
        }

        // Update the existing cart with the new cart's contents
        // This example assumes you want to replace the entire cart's contents
        // You might need to adjust this based on your actual requirements
        existingCart.setProducts(newCart.getProducts());

        // Persist the updated cart
        cartRepository.persist(existingCart);

        return existingCart;
    }

    @Transactional
    public Cart addProductToCart(Long userId, Product product) {
        return Optional.ofNullable(userRepository.findById(userId))
                .map(user -> {
                    Cart cart = user.getCart();
                    if (cart != null) {
                        Integer currentQuantity = cart.getProducts().getOrDefault(product, 0);
                        cart.getProducts().put(product, currentQuantity + 1);
                        cart.setTotalValue(calculateTotalCartValue(cart)); // Pass the cart object
                        cartRepository.persist(cart);
                    }
                    return cart;
                })
                .orElseThrow(() -> new IllegalArgumentException("User not found for userId: " + userId));
    }

    @Transactional
    public Cart removeProductFromCart(Long userId, Product product) {
        return Optional.ofNullable(userRepository.findById(userId))
                .map(user -> {
                    Cart cart = user.getCart();
                    if (cart != null) {
                        Integer currentQuantity = cart.getProducts().get(product);
                        if (currentQuantity != null) {
                            if (currentQuantity > 1) {
                                cart.getProducts().put(product, currentQuantity - 1);
                            } else {
                                cart.getProducts().remove(product);
                            }
                            cart.setTotalValue(calculateTotalCartValue(cart)); // Pass the cart object
                            cartRepository.persist(cart);
                        }
                    }
                    return cart;
                })
                .orElseThrow(() -> new IllegalArgumentException("User not found for userId: " + userId));
    }

    @Transactional
    public Cart updateProductQuantity(Long userId, Product product, int quantityChange) {
        return Optional.ofNullable(userRepository.findById(userId))
                .map(user -> {
                    Cart cart = user.getCart();
                    if (cart != null) {
                        Integer currentQuantity = cart.getProducts().get(product);
                        if (currentQuantity != null) {
                            int newQuantity = currentQuantity + quantityChange;
                            if (newQuantity > 0) {
                                cart.getProducts().put(product, newQuantity);
                            } else {
                                cart.getProducts().remove(product);
                            }
                            cart.setTotalValue(calculateTotalCartValue(cart)); // Pass the cart object
                            cartRepository.persist(cart);
                        }
                    }
                    return cart;
                })
                .orElseThrow(() -> new IllegalArgumentException("User not found for userId: " + userId));
    }

    public BigDecimal calculateTotalCartValue(Cart cart) {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            BigDecimal productPrice = BigDecimal.valueOf(product.getPrice());
            total = total.add(productPrice.multiply(BigDecimal.valueOf(quantity)));
        }
        return total;
    }

}