package com.fudgelate.repository;

import com.fudgelate.model.Product;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

public interface ProductRepository extends PanacheRepositoryBase<Product, Long> {

}