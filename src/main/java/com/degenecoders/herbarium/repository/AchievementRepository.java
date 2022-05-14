package com.degenecoders.herbarium.repository;

import com.degenecoders.herbarium.model.Achievement;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AchievementRepository {
    @Inject
    MongoClient mongoClient;

    private MongoCollection<Document> getAchievementsCollection() {
        return mongoClient.getDatabase("Herbarium").getCollection("Achievement");
    }

    public List<Achievement> findAllByAchievement(String Id) {
        List<Achievement> achievements = new ArrayList<>();
        MongoCursor<Document> cursor = getAchievementsCollection().find(new Document("id", Id)).iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();

                Achievement achievement = Achievement.builder()
                        .id(document.getString("id"))
                        .name(document.getString("name"))
                        .description(document.getString("description"))
                        .image(document.getString("image"))
                        .points(document.getString("points"))
                        .status(document.getBoolean("status"))
                        .build();
                achievements.add(achievement);
            }
        } finally {
            cursor.close();
        }

        return achievements;
    }

    public List<Achievement> findAllAchievements() {
        List<Achievement> achievements = new ArrayList<>();
        MongoCursor<Document> cursor = getAchievementsCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();

                Achievement achievement = Achievement.builder()
                        .id(document.getString("id"))
                        .name(document.getString("name"))
                        .description(document.getString("description"))
                        .image(document.getString("image"))
                        .points(document.getString("points"))
                        .status(document.getBoolean("status"))
                        .build();
                achievements.add(achievement);
            }
        } finally {
            cursor.close();
        }

        return achievements;
    }

    public void add(Achievement achievement) {
        Document document = new Document()
                .append("id", achievement.getId())
                .append("name", achievement.getName())
                .append("description", achievement.getDescription())
                .append("image", achievement.getImage())
                .append("points", achievement.getPoints())
                .append("status", achievement.getStatus());
        getAchievementsCollection().insertOne(document);
    }

    public void update(Achievement achievement) {
        Document document = new Document()
                .append("id", achievement.getId())
                .append("name", achievement.getName())
                .append("description", achievement.getDescription())
                .append("image", achievement.getImage())
                .append("points", achievement.getPoints())
                .append("status", achievement.getStatus());
        getAchievementsCollection().updateOne(new Document("_id", achievement.getId()), new Document("$set", document));
    }
}
