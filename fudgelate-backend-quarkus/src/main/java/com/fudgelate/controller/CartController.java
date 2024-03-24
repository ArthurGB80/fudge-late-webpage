package com.fudgelate.controller;

import com.fudgelate.model.Cart;
import com.fudgelate.model.Order;
import com.fudgelate.service.CartService;
import com.fudgelate.service.OrderService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
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
    private final OrderService orderService;

    @Inject
    public CartController(CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @POST
    @Path("/create")
    public Cart createCart(Cart cart) {
        return cartService.createCartForUser(cart.getCartid());
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

    @POST
    @Path("/create")
    public Response createOrder(Long userId) {
        try {
            Order order = orderService.createOrder(userId);
            if (order != null) {
                // Process payment
                boolean paymentSuccessful = orderService.processPayment(order);
                if (paymentSuccessful) {
                    // Update order status to "COMPLETED"
                    orderService.updateOrderStatus(order.getId(), "COMPLETED");
                    // Send confirmation email
                    orderService.sendConfirmationEmail(order);
                    return Response.ok(order).build();
                } else {
                    // Update order status to "FAILED"
                    orderService.updateOrderStatus(order.getId(), "FAILED");
                    return Response.status(Response.Status.PAYMENT_REQUIRED).entity("Payment failed").build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Order could not be created").build();
            }
        } catch (Exception e) {
            // Handle exceptions and return appropriate response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred while processing the order").build();
        }
    }

}