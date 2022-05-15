package com.degenecoders.herbarium.repository;

import com.degenecoders.herbarium.model.Plant;
import com.degenecoders.herbarium.service.impl.AmazonS3StorageServiceImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.and;


@ApplicationScoped
public class PlantRepository {
    @Inject
    private MongoClient mongoClient;

    @Inject
    private AmazonS3StorageServiceImpl storageService;

    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase("Herbarium").getCollection("Plant");
    }

    public List<Plant> findAllByUser(String userId) {
        List<Plant> plants = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find(eq("userId", userId)).iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();

                Plant plant = Plant.builder()
                        .id(document.getObjectId("_id").toHexString())
                        .name(document.getString("name"))
                        .description(document.getString("description"))
                        .filepath(document.getString("filepath"))
                        .userId(document.getString("userId"))
                        .build();

                String image = storageService.retrieve(plant.getFilepath());
                plant.setImage(image);
                plants.add(plant);
            }
        } finally {
            cursor.close();
        }

        return plants;
    }

    public Plant findPlantByUser(String userId, String plantId) {
        //TODO: FIX THIS problem with string parsing into ObjectId
        BasicDBObject query = new BasicDBObject("_id", new ObjectId(plantId));
        Document document = getCollection().find(and(eq("userId", userId), query)).first();

        return Plant.builder()
                .id(document.getObjectId("_id").toString())
                .name(document.getString("name"))
                .description(document.getString("description"))
                .filepath(document.getString("filepath"))
                .latinName(document.getString("latinName"))
                .latitude(document.getDouble("latitude"))
                .longitude(document.getDouble("longitude"))
                .userId(document.getString("userId"))
                .build();
    }

    public void add(Plant plant) {
        Document document = new Document()
                .append("name", plant.getName())
                .append("description", plant.getDescription())
                .append("filepath", plant.getFilepath())
                .append("userId", plant.getUserId());

        getCollection().insertOne(document);
    }
}
