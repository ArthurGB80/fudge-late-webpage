package com.fudgelate.controller;

import java.security.NoSuchAlgorithmException;

import com.fudgelate.model.User;
import com.fudgelate.service.UserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Path("/register")
    public User registerUser(User user) {
        try {
            return userService.createUser(user);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GET
    @Path("/{id}")
    public Response getUser(@PathParam("id") Long id) {
    User user = userService.getUser(id);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, User newUser) {
        User updatedUser = userService.updateUser(id, newUser);
        if (updatedUser != null) {
            return Response.ok(updatedUser).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        if (userService.deleteUser(id)) {
            return Response.ok("User deleted successfully").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}