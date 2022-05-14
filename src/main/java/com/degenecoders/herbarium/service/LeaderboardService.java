package com.degenecoders.herbarium.service;

import com.degenecoders.herbarium.model.Leaderboard;

import java.util.List;

public interface LeaderboardService {
    /**
     * Find all leaderboard items in collection by used ID.
     *
     * @param Id leaderboard id
     * @return collection of plants
     */
    public List<Leaderboard> findAllByLeaderboard(String Id);

    /**
     * Find all leaderboards
     *
     * @return collection of leaderboard
     */
    public List<Leaderboard> findAllLeaderboards();

    /**
     * Add new leaderbord item to the collection.
     *
     * @param leaderboard information
     * @return newly added achievement
     */
    public void add(Leaderboard leaderboard);
}
