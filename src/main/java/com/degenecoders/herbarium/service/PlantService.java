package com.degenecoders.herbarium.service;

import com.degenecoders.herbarium.model.Plant;

import javax.ws.rs.core.Response;
import java.util.List;

public interface PlantService {
    /**
     * Find all plants collection by used ID.
     *
     * @param userId user id
     * @return collection of plants
     */
    public List<Plant> findAllByUser(String userId);

    /**
     * Find specific plant that user has.
     *
     * @param userId user id
     * @param plantId plant id
     * @return single plant
     */
    public Plant findPlantByUser(String userId, String plantId);

    /**
     *
     *
      * @param plant
     * @return
     */
    public void add(Plant plant);
}
