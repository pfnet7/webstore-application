package com.webstoreapp;

import com.webstoreapp.authentication.Secured;
import com.webstoreapp.entity.Offer;
import com.webstoreapp.error.ErrorResponse;
import com.webstoreapp.mybatis.OfferService;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
@Path("/offer")
public class OfferController {

    @Inject
    private OfferService offerService;

    @Context
    private UriInfo uriInfo;

    @POST
    @Secured
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOffer(Offer offer) {
        Offer outputOffer = offerService.createOffer(offer);

        String selfUri = uriInfo.getAbsolutePath().toString() + offer.getId().toString();
        offer.addLink("self", selfUri);
        return Response.ok(outputOffer).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOfferById(@PathParam("id") Integer id) {
        Optional<Offer> outputOffer = Optional.ofNullable(offerService.getOfferById(id));

        if (!outputOffer.isPresent()) {
            return ErrorResponse.buildNotFoundResponse();
        }

        String selfUri = uriInfo.getAbsolutePath().toString() + id.toString();
        outputOffer.get().addLink("self", selfUri);

        return Response.ok(outputOffer.get()).build();
    }

    @PUT
    @Secured
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOffer(@PathParam("id") Integer id, Offer newOffer) {
        Optional<Offer> offer = Optional.ofNullable(offerService.getOfferById(id));

        if (!offer.isPresent()) {
            return ErrorResponse.buildNotFoundResponse();
        }
        Offer updatedOffer = offerService.updateOffer(id, newOffer);

        String selfUri = uriInfo.getAbsolutePath().toString() + id.toString();
        updatedOffer.addLink("self", selfUri);

        return Response.ok(updatedOffer).build();

    }

    @DELETE
    @Secured
    @Path("{id}")
    public Response deleteOffer(@PathParam("id") Integer id) {
        Optional<Offer> offer = Optional.ofNullable(offerService.getOfferById(id));

        if (!offer.isPresent()) {
            return ErrorResponse.buildNotFoundResponse();
        }

        offerService.deleteOfferById(id);
        return Response.ok().build();

    }

}
