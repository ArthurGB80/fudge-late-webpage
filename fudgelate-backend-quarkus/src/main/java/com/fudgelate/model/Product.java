package com.fudgelate.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotEmpty
    @NotNull
    private String name;

    @NotNull
    private Double price;

    @Min(0)
    private Integer inventoryCount;

    private String description;
    private String category;
    private String imageUrl;
    private Double weight;
    private String dimensions;
    private LocalDateTime releaseDate;
    private Double discountedPrice;

    public Product() {
    }

    public Product(Long productId, String name, Double price, Integer inventoryCount, String description,
            String category, String imageUrl, Double weight, String dimensions, LocalDateTime releaseDate,
            Double discountedPrice) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.inventoryCount = inventoryCount;
        this.description = description;
        this.category = category;
        this.imageUrl = imageUrl;
        this.weight = weight;
        this.dimensions = dimensions;
        this.releaseDate = releaseDate;
        this.discountedPrice = discountedPrice;
    }

    public Long getProductId() {
        return this.productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventoryCount() {
        return this.inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getWeight() {
        return this.weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public LocalDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getDiscountedPrice() {
        return this.discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Product productId(Long productId) {
        setProductId(productId);
        return this;
    }

    public Product name(String name) {
        setName(name);
        return this;
    }

    public Product price(Double price) {
        setPrice(price);
        return this;
    }

    public Product inventoryCount(Integer inventoryCount) {
        setInventoryCount(inventoryCount);
        return this;
    }

    public Product description(String description) {
        setDescription(description);
        return this;
    }

    public Product category(String category) {
        setCategory(category);
        return this;
    }

    public Product imageUrl(String imageUrl) {
        setImageUrl(imageUrl);
        return this;
    }

    public Product weight(Double weight) {
        setWeight(weight);
        return this;
    }

    public Product dimensions(String dimensions) {
        setDimensions(dimensions);
        return this;
    }

    public Product releaseDate(LocalDateTime releaseDate) {
        setReleaseDate(releaseDate);
        return this;
    }

    public Product discountedPrice(Double discountedPrice) {
        setDiscountedPrice(discountedPrice);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(name, product.name)
                && Objects.equals(price, product.price) && Objects.equals(inventoryCount, product.inventoryCount)
                && Objects.equals(description, product.description) && Objects.equals(category, product.category)
                && Objects.equals(imageUrl, product.imageUrl) && Objects.equals(weight, product.weight)
                && Objects.equals(dimensions, product.dimensions) && Objects.equals(releaseDate, product.releaseDate)
                && Objects.equals(discountedPrice, product.discountedPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, inventoryCount, description, category, imageUrl, weight, dimensions,
                releaseDate, discountedPrice);
    }

    @Override
    public String toString() {
        return "{" +
                " productId='" + getProductId() + "'" +
                ", name='" + getName() + "'" +
                ", price='" + getPrice() + "'" +
                ", inventoryCount='" + getInventoryCount() + "'" +
                ", description='" + getDescription() + "'" +
                ", category='" + getCategory() + "'" +
                ", imageUrl='" + getImageUrl() + "'" +
                ", weight='" + getWeight() + "'" +
                ", dimensions='" + getDimensions() + "'" +
                ", releaseDate='" + getReleaseDate() + "'" +
                ", discountedPrice='" + getDiscountedPrice() + "'" +
                "}";
    }

}