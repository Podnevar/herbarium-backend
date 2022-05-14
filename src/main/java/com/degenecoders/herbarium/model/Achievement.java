package com.degenecoders.herbarium.model;

import lombok.*;

@Data
@Builder(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode

public class Achievement {
    private String id;
    private String name;
    private String description;
    private String image;
    private Boolean status;

    public Achievement() {
    }

    public Achievement(String id, String name, String description, String image, Boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.status = status;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}

