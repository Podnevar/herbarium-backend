package com.degenecoders.herbarium.service.impl;

import com.degenecoders.herbarium.model.Plant;
import com.degenecoders.herbarium.repository.PlantRepository;
import com.degenecoders.herbarium.service.PlantService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PlantServiceImpl implements PlantService {
    @Inject
    private PlantRepository plantRepository;

    @Override
    public List<Plant> findAllByUser(String userId) {
        return plantRepository.findAllByUser(userId);
    }

    @Override
    public Plant findPlantByUser(String userId, String plantId) {
        return plantRepository.findPlantByUser(userId, plantId);
    }

    @Override
    public void add(Plant plant) {
        plantRepository.add(plant);
    }
}
