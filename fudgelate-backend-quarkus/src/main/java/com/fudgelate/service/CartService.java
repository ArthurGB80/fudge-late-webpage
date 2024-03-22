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
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CartService {

    private final CartRepository cartRepository;
    private static UserRepository userRepository = new UserRepository();

    @Inject
    public CartService(CartRepository cartRepository, UserRepository userRepository) { // Update this constructor
        this.cartRepository = cartRepository;
        CartService.userRepository = userRepository; // And this line
    }

    @Transactional
    public Cart createCartForUser(Long userId) {
        return Optional.ofNullable(userRepository.findById(userId))
                .map(user -> {
                    Cart cart = new Cart();
                    cart.setUser(user);
                    cartRepository.persist(cart);

                    user.setCart(cart);
                    userRepository.persist(user);

                    return cart;
                })
                .orElse(null);
    }

    @Transactional
    public Cart addProductToCart(Long userId, Product product) {
        return Optional.ofNullable(userRepository.findById(userId))
                .map(user -> {
                    Cart cart = user.getCart();
                    if (cart != null) {
                        Integer currentQuantity = cart.getProducts().get(product);
                        if (currentQuantity != null) {
                            cart.getProducts().put(product, currentQuantity + 1);
                        } else {
                            cart.getProducts().put(product, 1);
                        }
                        cartRepository.persist(cart);
                    }
                    return user.getCart();
                })
                .orElse(null);
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
                            cartRepository.persist(cart);
                        }
                    }
                    return user.getCart();
                })
                .orElse(null);
    }

    @Transactional
    public Cart removeProductFromCart(Long userId, Product product) {
        return Optional.ofNullable(userRepository.findById(userId))
                .map(user -> {
                    Cart cart = user.getCart();
                    if (cart != null) {
                        cart.getProducts().remove(product);
                        cartRepository.persist(cart);
                    }
                    return user.getCart();
                })
                .orElse(null);
    }

    public static BigDecimal calculateTotalCartValue(Long userId) {
        User user = userRepository.findById(userId);
        if (user != null) {
            Cart cart = user.getCart();
            if (cart != null) {
                BigDecimal total = BigDecimal.ZERO;
                for (Map.Entry<Product, Integer> entry : cart.getProducts().entrySet()) {
                    Product product = entry.getKey();
                    Integer quantity = entry.getValue();
                    // Convert the Double price to BigDecimal
                    BigDecimal productPrice = BigDecimal.valueOf(product.getPrice());
                    total = total.add(productPrice.multiply(BigDecimal.valueOf(quantity)));
                }
                return total;
            }
        }
        return BigDecimal.ZERO;
    }

}