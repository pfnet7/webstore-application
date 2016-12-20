package com.webstoreapp;

import com.webstoreapp.authentication.AuthenticatedUser;
import com.webstoreapp.authentication.Secured;
import com.webstoreapp.entity.User;
import com.webstoreapp.mybatis.OrderService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/order")
public class OrderController {

    @Inject
    @AuthenticatedUser
    private User authenticatedUser;

    @Inject
    private OrderService orderService;

    @POST
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(@QueryParam("orderId") Integer orderId) {

        orderService.createOrder(orderId, authenticatedUser.getId(), "CREATED");
        return Response.ok(orderService.getOrderById(orderId)).build();        

    }

    @GET
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(Integer orderId) {

        return Response.ok(orderService.getOrderById(orderId)).build();

    }

}
