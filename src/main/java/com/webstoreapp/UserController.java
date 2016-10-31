package com.webstoreapp;

import com.webstoreapp.entity.User;
import com.webstoreapp.error.ErrorResponse;
import com.webstoreapp.error.InvalidEntityException;
import com.webstoreapp.mybatis.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserController {

    Logger logger = LogManager.getLogger(UserController.class);

    @Inject
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) throws ServletException {
        logger.info(user);

        try {
            user.validate();
        } catch (InvalidEntityException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return Response.status(HttpServletResponse.SC_BAD_REQUEST).entity(errorResponse).build();
        }

        User outputUser = userService.createUser(user);
        return Response.status(HttpServletResponse.SC_OK).entity(outputUser).build();
    }

}
