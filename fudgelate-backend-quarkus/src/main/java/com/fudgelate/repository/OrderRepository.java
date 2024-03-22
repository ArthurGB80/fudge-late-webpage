package com.fudgelate.repository;

import com.fudgelate.model.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {
    // You can define custom query methods here if needed
}