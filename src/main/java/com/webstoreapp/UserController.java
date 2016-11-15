package com.webstoreapp;

import com.webstoreapp.entity.User;
import com.webstoreapp.error.ErrorResponse;
import com.webstoreapp.error.InvalidEntityException;
import com.webstoreapp.mybatis.UserService;
import io.swagger.annotations.Api;

import java.net.URI;

import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Api
@Path("/user")
public class UserController {

    @Inject
    private UserService userService;

    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {

        try {
            user.validate();
        } catch (InvalidEntityException e) {
            return ErrorResponse.buildBadRequestResponse(e.getMessage());
        }

        User outputUser = userService.createUser(user);
        return Response.ok(outputUser).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") Long id) {
        Optional<User> outputUser = Optional.ofNullable(userService.getUserById(id));

        if (!outputUser.isPresent()) {
            return ErrorResponse.buildNotFoundResponse();
        }

        User user = outputUser.get();

        URI selfUri = uriInfo.getRequestUri();
        user.addLink("self", selfUri.toString());

        return Response.ok(user).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Long id, User newUser) {
        Optional<User> user = Optional.ofNullable(userService.getUserById(id));

        if (!user.isPresent()) {
            return ErrorResponse.buildNotFoundResponse();
        }

        User updatedUser = userService.updateUser(id, newUser);
        return Response.ok(updatedUser).build();
    }

}
