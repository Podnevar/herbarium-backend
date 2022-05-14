package com.degenecoders.herbarium.model;

import lombok.*;

@Data
@Builder(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode

public class Leaderboard {
    private String id;
    private String username;
    private String points;
    private String rank;
    private String rankTitle;

    public Leaderboard() {
    }

    public Leaderboard(String id, String username, String points, String rank, String rankTitle) {
        this.id = id;
        this.username = username;
        this.points = points;
        this.rank = rank;
        this.rankTitle = rankTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRankTitle() {
        return rankTitle;
    }

    public void setRankTitle(String rankTitle) {
        this.rankTitle = rankTitle;
    }
}
