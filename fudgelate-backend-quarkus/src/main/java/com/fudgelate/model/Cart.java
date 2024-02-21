package com.fudgelate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartDetails> cartDetails;

    public Cart() {
        this.cartDetails = new ArrayList<>();
    }

    public Cart(Long id, List<CartDetails> cartDetails) {
        this.id = id;
        this.cartDetails = cartDetails;
    }

    public Cart(List<CartDetails> cartDetails) {
        this.cartDetails = cartDetails;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart id(Long id) {
        setId(id);
        return this;
    }

    public Cart cartDetails(List<CartDetails> cartDetails) {
        setCartDetails(cartDetails);
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
        return Objects.equals(id, cart.id) && Objects.equals(cartDetails, cart.cartDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cartDetails);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", cartDetails='" + getCartDetails() + "'" +
                "}";
    }

    public List<CartDetails> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(List<CartDetails> cartDetails) {
        this.cartDetails = cartDetails;
    }
}