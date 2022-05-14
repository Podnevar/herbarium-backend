package com.degenecoders.herbarium.resources;


import com.degenecoders.herbarium.model.Plant;
import com.degenecoders.herbarium.service.PlantService;
import com.degenecoders.herbarium.service.impl.FileUploadService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/collection")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CollectionResource {
    @Inject
    private PlantService plantService;

    @Inject
    private FileUploadService fileUploadService;

    @POST
    public Response add(Plant plant) {
        plantService.add(plant);
        return Response.ok().status(201).build();
    }

    @GET
    public Plant getPlant() {
        Plant plant = Plant.builder()
                .id("test")
                .name("test")
                .description("test")
                .filepath("test")
                .latinName("test")
                .latitude(0)
                .longitude(0)
                .userId("test")
                //.rarity(document.getString(RarityEnum.RARE))
                .build();
        return plant;
    }

    @POST
    @Path("/files")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response fileUpload(@MultipartForm MultipartFormDataInput input) {
        return Response.ok().
                entity(fileUploadService.uploadFile(input)).build();
    }
}