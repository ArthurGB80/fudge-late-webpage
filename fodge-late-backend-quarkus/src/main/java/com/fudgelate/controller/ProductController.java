package com.fudgelate.controller;

import java.util.List;

import com.fudgelate.model.Product;
import com.fudgelate.service.ProductService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/products")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    // Add more methods as needed...
}