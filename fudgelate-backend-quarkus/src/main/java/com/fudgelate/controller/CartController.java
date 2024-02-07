package com.fudgelate.controller;


import com.fudgelate.model.Cart;
import com.fudgelate.service.CartService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;




@Path("/api/cart")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartController {

    private final CartService cartService;

    @Inject
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @POST
    @Path("/create")
    public Cart createCart(Cart cart) {
        return cartService.createCart(cart);
    }

    @GET
    @Path("/{id}")
    public Response getCart(@PathParam("id") Long id) {
        Cart cart = cartService.getCart(id);
        if (cart != null) {
            return Response.ok(cart).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateCart(@PathParam("id") Long id, Cart newCart) {
        Cart updatedCart = cartService.updateCart(id, newCart);
        if (updatedCart != null) {
            return Response.ok(updatedCart).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCart(@PathParam("id") Long id) {
        if (cartService.deleteCart(id)) {
            return Response.ok("Cart deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}