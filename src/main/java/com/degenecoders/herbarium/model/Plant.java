package com.degenecoders.herbarium.model;

import lombok.*;

@Data
@Builder(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
public class Plant {
    /**
     * Plant ID.
     */
    private String id;
    /**
     * Plant name.
     */
    private String name;
    /**
     * Plant description.
     */
    private String description;
    /**
     * Filepath of the image on cloud storage.
     */
    private String filepath;
    /**
     * Base64 encoding of image.
     */
    private String image;
    /**
     * Latin name of the plant.
     */
    private String latinName;
    /**
     * GPS latitude
     */
    private double latitude;
    /**
     * GPS longitude
     */
    private double longitude;
    /**
     * User ID
     */
    private String userId;
    /**
     * Rarity of the plant
     */
    private RarityEnum rarity;

    public Plant() {
    }

    public Plant(String id, String name, String description, String filepath, String image, String latinName, double latitude, double longitude, String userId, RarityEnum rarity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.filepath = filepath;
        this.image = image;
        this.latinName = latinName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userId = userId;
        this.rarity = rarity;
    }
}
