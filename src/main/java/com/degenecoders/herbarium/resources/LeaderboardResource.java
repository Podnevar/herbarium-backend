package com.degenecoders.herbarium.resources;

import com.degenecoders.herbarium.model.Achievement;
import com.degenecoders.herbarium.model.Leaderboard;
import com.degenecoders.herbarium.service.AchievementService;
import com.degenecoders.herbarium.service.LeaderboardService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/leaderboards")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LeaderboardResource {
    @Inject
    private LeaderboardService leaderboardService;

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leaderboard> findAllByLeaderboard(@PathParam("id") String Id)
    {
        return leaderboardService.findAllByLeaderboard(Id);
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Leaderboard> findAllByLeaderboard() {
        return leaderboardService.findAllLeaderboards();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Leaderboard leaderboard) {
        leaderboardService.add(leaderboard);
        return Response.ok().status(201).build();
    }
}
