package com.degenecoders.herbarium.service.impl;

import com.degenecoders.herbarium.model.Achievement;
import com.degenecoders.herbarium.model.Plant;
import com.degenecoders.herbarium.repository.AchievementRepository;
import com.degenecoders.herbarium.service.AchievementService;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class AchievementServiceImpl implements AchievementService {

    @Inject
    private AchievementRepository achievementRepository;
    private static final Logger LOG = Logger.getLogger(Plant.class);

    @Override
    public List<Achievement> findAllByAchievement(String Id) {
        return achievementRepository.findAllByAchievement(Id);
    }

    @Override
    public List<Achievement> findAllAchievements() {
        return achievementRepository.findAllAchievements();
    }

    @Override
    public void add(Achievement achievement) {
        achievementRepository.add(achievement);
    }

    @Override
    public void update(Achievement achievement) {
        achievementRepository.update(achievement);
    }
}
