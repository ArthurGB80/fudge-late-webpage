package com.fudgelate.controller;

import java.util.List;

import com.fudgelate.model.Product;
import com.fudgelate.service.ProductService;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/products")
public class ProductController {

    private final ProductService productService;

    @Inject
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        Product product = productService.getProduct(id);
        if (product != null) {
            return Response.ok(product).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

        @POST
    @Path("/create")
    public Product createProduct(Product product) {
        return productService.addProduct(product);
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product newProduct) {
        Product updatedProduct = productService.updateProduct(id, newProduct);
        if (updatedProduct != null) {
            return Response.ok(updatedProduct).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        if (productService.deleteProduct(id)) {
            return Response.ok("Product deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}