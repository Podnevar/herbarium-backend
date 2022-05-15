package com.degenecoders.herbarium.client;

import com.degenecoders.herbarium.model.PlantidRequest;
import com.degenecoders.herbarium.model.PlantidResponse;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v2")
@RegisterRestClient
public interface PlantidServiceClient {
    @POST
    @Path("/identify")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Response identify(@HeaderParam("Api-Key") String key, @RequestBody PlantidRequest request);
}
