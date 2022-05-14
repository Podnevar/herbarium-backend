package com.degenecoders.herbarium.repository;

import com.degenecoders.herbarium.model.Achievement;
import com.degenecoders.herbarium.model.Leaderboard;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class LeaderboardRepository {
    @Inject
    MongoClient mongoClient;

    private MongoCollection<Document> getLeaderboardsCollection() {
        return mongoClient.getDatabase("Herbarium").getCollection("Leaderboard");
    }

    public List<Leaderboard> findAllByLeaderboard(String Id) {
        List<Leaderboard> leaderboards = new ArrayList<>();
        MongoCursor<Document> cursor = getLeaderboardsCollection().find(new Document("id", Id)).iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();

                Leaderboard leaderboard = Leaderboard.builder()
                        .id(document.getString("id"))
                        .username(document.getString("username"))
                        .points(document.getString("points"))
                        .rank(document.getString("rank"))
                        .rankTitle(document.getString("rankTitle"))
                        .build();
                leaderboards.add(leaderboard);
            }
        } finally {
            cursor.close();
        }

        return leaderboards;
    }

    public List<Leaderboard> findAllLeaderboards() {
        List<Leaderboard> achievements = new ArrayList<>();
        MongoCursor<Document> cursor = getLeaderboardsCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();

                Leaderboard leaderboard = Leaderboard.builder()
                        .id(document.getString("id"))
                        .username(document.getString("username"))
                        .points(document.getString("points"))
                        .rank(document.getString("rank"))
                        .rankTitle(document.getString("rankTitle"))
                        .build();
                achievements.add(leaderboard);
            }
        } finally {
            cursor.close();
        }

        return achievements;
    }

    public void add(Leaderboard leaderboard) {
        Document document = new Document()
                .append("id", leaderboard.getId())
                .append("username", leaderboard.getUsername())
                .append("points", leaderboard.getPoints())
                .append("rank", leaderboard.getRank())
                .append("rankTitle", leaderboard.getRankTitle());
        getLeaderboardsCollection().insertOne(document);
    }
}
