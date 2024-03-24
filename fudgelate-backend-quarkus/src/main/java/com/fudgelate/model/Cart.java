package com.fudgelate.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartid;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ElementCollection
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Integer> products = new HashMap<>();

    private BigDecimal totalValue;

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }


    public Cart() {
    }

    public Cart(Long cartid, User user, Map<Product,Integer> products) {
        this.cartid = cartid;
        this.user = user;
        this.products = products;
    }

    public Long getCartid() {
        return this.cartid;
    }

    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Product,Integer> getProducts() {
        return this.products;
    }

    public void setProducts(Map<Product,Integer> products) {
        this.products = products;
    }

    public Cart cartid(Long cartid) {
        setCartid(cartid);
        return this;
    }

    public Cart user(User user) {
        setUser(user);
        return this;
    }

    public Cart products(Map<Product,Integer> products) {
        setProducts(products);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) o;
        return Objects.equals(cartid, cart.cartid) && Objects.equals(user, cart.user) && Objects.equals(products, cart.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartid, user, products);
    }

    @Override
    public String toString() {
        return "{" +
            " cartid='" + getCartid() + "'" +
            ", user='" + getUser() + "'" +
            ", products='" + getProducts() + "'" +
            "}";
    }
    
}