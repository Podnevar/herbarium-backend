package com.degenecoders.herbarium.resources;

import com.degenecoders.herbarium.model.Achievement;
import com.degenecoders.herbarium.service.AchievementService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/achievements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AchievementResource {
    @Inject
    private AchievementService achievementService;

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Achievement> findAllByAchivement(@PathParam("id") String Id)
    {
        return achievementService.findAllByAchievement(Id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Achievement> findAllByAchievement() {
        return achievementService.findAllAchievements();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Achievement achievement) {
        achievementService.add(achievement);
        return Response.ok().status(201).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(Achievement achievement) {
        achievementService.update(achievement);
        return Response.ok().status(201).build();
    }
}
