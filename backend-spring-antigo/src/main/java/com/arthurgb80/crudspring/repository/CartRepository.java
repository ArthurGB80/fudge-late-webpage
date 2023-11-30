
package com.arthurgb80.crudspring.repository;

import com.arthurgb80.crudspring.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
