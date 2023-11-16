package com.fudgelate.repository;

import com.fudgelate.model.User;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

public interface UserRepository extends PanacheRepositoryBase<User, Long> {
}