
package com.degenecoders.herbarium.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "plant_name",
    "plant_details",
    "probability",
    "confirmed",
    "similar_images"
})
@Generated("jsonschema2pojo")
public class Suggestion {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("plant_name")
    private String plantName;
    @JsonProperty("plant_details")
    private PlantDetails plantDetails;
    @JsonProperty("probability")
    private Double probability;
    @JsonProperty("confirmed")
    private Boolean confirmed;
    @JsonProperty("similar_images")
    private List<SimilarImage> similarImages = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("plant_name")
    public String getPlantName() {
        return plantName;
    }

    @JsonProperty("plant_name")
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    @JsonProperty("plant_details")
    public PlantDetails getPlantDetails() {
        return plantDetails;
    }

    @JsonProperty("plant_details")
    public void setPlantDetails(PlantDetails plantDetails) {
        this.plantDetails = plantDetails;
    }

    @JsonProperty("probability")
    public Double getProbability() {
        return probability;
    }

    @JsonProperty("probability")
    public void setProbability(Double probability) {
        this.probability = probability;
    }

    @JsonProperty("confirmed")
    public Boolean getConfirmed() {
        return confirmed;
    }

    @JsonProperty("confirmed")
    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @JsonProperty("similar_images")
    public List<SimilarImage> getSimilarImages() {
        return similarImages;
    }

    @JsonProperty("similar_images")
    public void setSimilarImages(List<SimilarImage> similarImages) {
        this.similarImages = similarImages;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
