package com.fudgelate.repository;

import com.fudgelate.model.Cart;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CartRepository implements PanacheRepository<Cart> {
    // additional custom methods if needed
}