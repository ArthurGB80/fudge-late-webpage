package com.fudgelate.service;

import com.fudgelate.model.Cart;
import com.fudgelate.repository.CartRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CartService {

    @Inject
    CartRepository cartRepository;

    @Transactional
    public Cart createCart(Cart cart) {
        cartRepository.persist(cart);
        return cart;
    }

    // Other service methods...
}