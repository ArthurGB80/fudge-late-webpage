package com.arthurgb80.crudspring.repository;

import com.arthurgb80.crudspring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}