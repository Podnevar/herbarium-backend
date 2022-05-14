package com.degenecoders.herbarium.service.impl;

import com.degenecoders.herbarium.model.Leaderboard;
import com.degenecoders.herbarium.model.Plant;
import com.degenecoders.herbarium.repository.LeaderboardRepository;
import com.degenecoders.herbarium.service.AchievementService;
import com.degenecoders.herbarium.service.LeaderboardService;
import org.jboss.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class LeaderboardServiceImpl implements LeaderboardService {
    @Inject
    private LeaderboardRepository leaderboardRepository;
    private static final Logger LOG = Logger.getLogger(Plant.class);

    @Override
    public List<Leaderboard> findAllByLeaderboard(String Id) {
        return leaderboardRepository.findAllByLeaderboard(Id);
    }

    @Override
    public List<Leaderboard> findAllLeaderboards() {
        return leaderboardRepository.findAllLeaderboards();
    }

    @Override
    public void add(Leaderboard leaderboard) {
        leaderboardRepository.add(leaderboard);
    }
}
