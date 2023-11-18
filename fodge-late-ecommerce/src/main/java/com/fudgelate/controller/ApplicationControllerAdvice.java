package com.fudgelate.controller;

import com.fudgelate.exception.RecordNotFoundException;

import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApplicationControllerAdvice {

    @Provider
    public static class RecordNotFoundExceptionMapper implements ExceptionMapper<RecordNotFoundException> {
        @Override
        public Response toResponse(RecordNotFoundException exception) {
            return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
        }
    }

    @Provider
    public static class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
        @Override
        public Response toResponse(ConstraintViolationException ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(ex.getConstraintViolations().stream()
                            .map(error -> error.getPropertyPath() + " " + error.getMessage())
                            .reduce("", (acc, error) -> acc + error + "\n"))
                    .build();
        }

        @Provider
        public static class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
            @Override
            public Response toResponse(BadRequestException ex) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Argument type not valid")
                        .build();
            }
        }
    }
}