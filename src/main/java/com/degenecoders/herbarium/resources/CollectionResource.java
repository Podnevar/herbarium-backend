package com.degenecoders.herbarium.resources;


import com.degenecoders.herbarium.model.Plant;
import com.degenecoders.herbarium.service.PlantService;
import com.degenecoders.herbarium.service.impl.FileUploadService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/collection")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CollectionResource {
    @Inject
    private PlantService plantService;

    @Inject
    private FileUploadService fileUploadService;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/user/{userId}")
    public Response getAllPlants(@PathParam("userId") String userId) {
        List<Plant> plants = plantService.findAllByUser(userId);
        return Response.ok(plants).build();
    }

    @GET
    @Path("/plant/{plantId}/user/{userId}")
    public Response getPlant(@PathParam("plantId") String plantId, @PathParam("userId") String userId) {
        Plant plant = plantService.findPlantByUser(plantId, userId);
        return Response.ok(plant).build();
    }

    @POST
    @Path("/upload/user/{username}")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response upload(@MultipartForm MultipartFormDataInput input, @PathParam("username") String username) {
        fileUploadService.upload(input, username);
        return Response.ok().status(201).build();
    }
}