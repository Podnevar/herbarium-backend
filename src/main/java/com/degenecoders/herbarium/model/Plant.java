package com.degenecoders.herbarium.model;

import lombok.*;

@Data
@Builder(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
public class Plant {
    private String id;
    private String name;
    private String description;
    private String filepath;
    private String latinName;
    private double latitude;
    private double longitude;
    private String userId;
    private RarityEnum rarity;

    public Plant() {
    }

    public Plant(String id, String name, String description, String filepath, String latinName, double latitude, double longitude, String userId, RarityEnum rarity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.filepath = filepath;
        this.latinName = latinName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userId = userId;
        this.rarity = rarity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RarityEnum getRarity() {
        return rarity;
    }

    public void setRarity(RarityEnum rarity) {
        this.rarity = rarity;
    }
}
