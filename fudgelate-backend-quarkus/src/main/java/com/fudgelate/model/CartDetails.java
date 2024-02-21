package com.fudgelate.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public CartDetails() {
    }

    public CartDetails(Long id, Cart cart, Product product, int quantity) {
        this.id = id;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartDetails id(Long id) {
        setId(id);
        return this;
    }

    public CartDetails cart(Cart cart) {
        setCart(cart);
        return this;
    }

    public CartDetails product(Product product) {
        setProduct(product);
        return this;
    }

    public CartDetails quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CartDetails)) {
            return false;
        }
        CartDetails cartDetails = (CartDetails) o;
        return Objects.equals(id, cartDetails.id) && Objects.equals(cart, cartDetails.cart)
                && Objects.equals(product, cartDetails.product) && quantity == cartDetails.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cart, product, quantity);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", cart='" + getCart() + "'" +
                ", product='" + getProduct() + "'" +
                ", quantity='" + getQuantity() + "'" +
                "}";
    }

}