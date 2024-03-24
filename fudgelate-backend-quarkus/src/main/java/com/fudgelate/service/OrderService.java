package com.fudgelate.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fudgelate.model.Cart;
import com.fudgelate.model.Order;
import com.fudgelate.repository.OrderRepository;
import com.fudgelate.repository.CartRepository;
import com.fudgelate.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Inject
    CartRepository cartRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    CartService cartService;

    @Transactional
    public Order createOrder(Long userId) {
        // Retrieve the user's cart
        Cart cart = cartRepository.findById(userId);
        if (cart == null) {
            throw new IllegalArgumentException("Cart not found for userId: " + userId);
        }

        // Calculate the total amount of the order
        BigDecimal totalAmount = cartService.calculateTotalCartValue(cart);

        // Create a new Order entity
        Order order = new Order();
        order.setUser(userRepository.findById(userId));
        order.setCart(cart);
        order.setTotalAmount(totalAmount);
        order.setStatus("PENDING"); // Assuming the initial status is "PENDING"
        order.setCreatedAt(LocalDateTime.now());

        // Save the order to the database
        orderRepository.persist(order);

        return order;
    }

    @Transactional
    public Order updateOrderStatus(Long orderId, String newStatus) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found for orderId: " + orderId);
        }
        order.setStatus(newStatus);
        orderRepository.persist(order);
        return order;
    }

    @Transactional
    public boolean processPayment(Order order) {
        // Placeholder for payment processing logic
        // This could involve calling an external payment gateway API
        // For now, let's assume the payment is always successful
        return true;
    }

    public void sendConfirmationEmail(Order order) {
        // Placeholder for sending confirmation emails
        // This could involve calling an email service or using a library like JavaMail
        // For now, let's assume the email is always sent successfully
        System.out.println("Confirmation email sent for order: " + order.getId());
    }

    // ... (other methods)
}
