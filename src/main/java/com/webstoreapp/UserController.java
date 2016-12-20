package com.webstoreapp;

import com.webstoreapp.authentication.Secured;
import com.webstoreapp.entity.User;
import com.webstoreapp.entity.UserData;
import com.webstoreapp.error.ErrorResponse;
import com.webstoreapp.error.InvalidEntityException;
import com.webstoreapp.mybatis.UserService;
// import io.swagger.annotations.Api;

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

// @Api
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
        userService.createUser(user);
        userService.createUserData(user.getId());

        String requestUri = uriInfo.getRequestUri().toString();
        String selfUri = requestUri + user.getUsername();
        String detailsUri = requestUri + "details";

        user.addLink("self", selfUri).addLink("details", detailsUri);

        return Response.ok(user).build();
    }

    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("username") String username) {
        Optional<User> outputUser = Optional.ofNullable(userService.getUserByUsername(username));

        if (!outputUser.isPresent()) {
            return ErrorResponse.buildNotFoundResponse();
        }

        User user = outputUser.get();

        String requestUri = uriInfo.getRequestUri().toString();
        String detailsUri = requestUri + "details";

        user.addLink("self", requestUri).addLink("details", detailsUri);

        return Response.ok(user).build();
    }

    @PUT
    @Secured
    @Path("{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("username") String username, User newUser) {
        Optional<User> user = Optional.ofNullable(userService.getUserByUsername(username));

        if (!user.isPresent()) {
            return ErrorResponse.buildNotFoundResponse();
        }

        User updatedUser = userService.updateUser(username, newUser);

        String requestUri = uriInfo.getRequestUri().toString();
        String detailsUri = requestUri + "details";

        user.get().addLink("self", requestUri).addLink("details", detailsUri);

        return Response.ok(updatedUser).build();
    }

    @PUT
    @Secured
    @Path("{username}/details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUserData(@PathParam("username") String username, UserData newUserData) {

        userService.updateUserData(username, newUserData);
        newUserData.addLink("self", uriInfo.getAbsolutePath().toString());
        return Response.ok(newUserData).build();

    }

}
