package com.fudgelate.service;

import com.fudgelate.model.Cart;
import com.fudgelate.repository.CartRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CartService {

    private final CartRepository cartRepository;    

    @Inject
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public Cart createCart(Cart cart) {
        cartRepository.persist(cart);
        return cart;
    }

    public Cart getCart(Long id) {
        return cartRepository.findById(id);
    }

    public Cart updateCart(Long id, Cart newCart) {
        Cart cart = cartRepository.findById(id);
        if (cart != null) {
            cart.setProducts(newCart.getProducts());
            // set other fields as needed...
            cartRepository.persist(cart);
        }
        return cart;
    }
    
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