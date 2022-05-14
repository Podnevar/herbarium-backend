package com.degenecoders.herbarium.repository;

import com.degenecoders.herbarium.model.Plant;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PlantRepository {
    @Inject
    MongoClient mongoClient;

    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("Herbarium").getCollection("Plant");
    }

    public List<Plant> findAllByUser(String userId) {
        List<Plant> plants = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find(new Document("userId", userId)).iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();

                Plant plant = Plant.builder()
                        .id(document.getString("_id"))
                        .name(document.getString("name"))
                        .description(document.getString("description"))
                        .filepath(document.getString("filepath"))
                        .latinName(document.getString("latinName"))
                        .latitude(document.getDouble("latitude"))
                        .longitude(document.getDouble("longitude"))
                        .userId(document.getString("userId"))
                        //.rarity(document.getString(RarityEnum.RARE))
                        .build();

                plants.add(plant);
            }
        } finally {
            cursor.close();
        }

        return plants;
    }

    public Plant findPlantByUser(String userId, String plantId) {
        return null;
    }

    public void add(Plant plant) {
        Document document = new Document()
                .append("id", plant.getId())
                .append("name", plant.getName())
                .append("description", plant.getDescription());
//                .append("filepath", plant.getFilepath())
//                .append("latinName", plant.getLatinName())
//                .append("latitude", plant.getLatitude())
//                .append("longitude", plant.getLongitude())
//                .append("userId", plant.getUserId());
//                .append("rarity", vinjeta.getVeljavnost());

        getCollection().insertOne(document);
    }
}
