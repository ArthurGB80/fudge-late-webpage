package com.fudgelate.controller;

import com.fudgelate.model.User;
import com.fudgelate.service.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {
    
    @Inject
    UserService userService;

    @POST
    @Path("/register")
    public User registerUser(User user) {
        return userService.createUser(user);
    }

    // Add more methods as needed...
}