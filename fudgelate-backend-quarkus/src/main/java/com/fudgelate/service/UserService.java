package com.fudgelate.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import com.fudgelate.model.User;
import com.fudgelate.repository.UserRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(User user) throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt);
        byte[] hashedPassword = md.digest(user.getPassword().getBytes(StandardCharsets.UTF_8));

        String storedUserPassword = Base64.getEncoder().encodeToString(hashedPassword);
        user.setPassword(storedUserPassword);
        userRepository.persist(user);
        return user;
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(Long id, User newUser) {
        User user = userRepository.findById(id);
        if (user != null) {
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            // set other fields
            userRepository.persist(user);
        }
        return user;
    }
    
    public boolean deleteUser(Long id) {
        User user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }

}