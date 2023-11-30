package com.arthurgb80.crudspring.controller;

import com.arthurgb80.crudspring.model.Cart;
import com.arthurgb80.crudspring.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/create")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    // Add more methods as needed...
}