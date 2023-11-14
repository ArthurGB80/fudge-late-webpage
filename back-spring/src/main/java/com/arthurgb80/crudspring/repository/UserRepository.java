package com.arthurgb80.crudspring.repository;

import com.arthurgb80.crudspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}