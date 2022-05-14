package com.degenecoders.herbarium.service.impl;

import com.degenecoders.herbarium.model.Plant;
import com.degenecoders.herbarium.repository.PlantRepository;
import com.degenecoders.herbarium.service.PlantService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PlantServiceImpl implements PlantService {
    @Inject
    private PlantRepository plantRepository;

    private static final Logger LOG = Logger.getLogger(Plant.class);

    @Override
    public List<Plant> findAllByUser(String userId) {
        return null;
    }

    @Override
    public Plant findPlantByUser(String userId, String plantId) {
        return null;
    }

    @Override
    public void add(Plant plant) {
        plantRepository.add(plant);
    }
}
