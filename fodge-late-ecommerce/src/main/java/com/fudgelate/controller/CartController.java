package com.fudgelate.controller;


import com.fudgelate.model.Cart;
import com.fudgelate.service.CartService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartController {

    @Inject
    CartService cartService;

    @POST
    @Path("/create")
    public Cart createCart(Cart cart) {
        return cartService.createCart(cart);
    }

    // Add more methods as needed...
}