package com.degenecoders.herbarium.service;

import com.degenecoders.herbarium.model.Achievement;
import com.degenecoders.herbarium.model.Plant;

import javax.ws.rs.core.Response;
import java.util.List;

public interface AchievementService {

    /**
     * Find all achievements collection by used ID.
     *
     * @param Id user id
     * @return collection of plants
     */
    public List<Achievement> findAllByAchievement(String Id);

    /**
     * Find all achievements
     *
     * @return collection of plants
     */
    public List<Achievement> findAllAchievements();

    /**
     * Add new achievement to the collection.
     *
     * @param achievement information
     * @return newly added achievement
     */
    public void add(Achievement achievement);

    /**
     * Change the status of the achievement. ( ON / OFF )
     *
     * @param achievement information
     * @return successfully changed achievement
     */
    public void update(Achievement achievement);
}
