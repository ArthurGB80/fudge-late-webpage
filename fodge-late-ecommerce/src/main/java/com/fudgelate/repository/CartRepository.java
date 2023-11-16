
package com.fudgelate.repository;

import com.fudgelate.model.Cart;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

public interface CartRepository extends PanacheRepositoryBase<Cart, Long> {
}
