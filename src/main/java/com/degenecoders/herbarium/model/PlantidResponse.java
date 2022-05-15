
package com.degenecoders.herbarium.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "custom_id",
    "meta_data",
    "uploaded_datetime",
    "finished_datetime",
    "images",
    "suggestions",
    "modifiers",
    "secret",
    "fail_cause",
    "countable",
    "feedback",
    "is_plant_probability",
    "is_plant"
})
@Generated("jsonschema2pojo")
public class PlantidResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("custom_id")
    private Object customId;
    @JsonProperty("meta_data")
    private MetaData metaData;
    @JsonProperty("uploaded_datetime")
    private Double uploadedDatetime;
    @JsonProperty("finished_datetime")
    private Double finishedDatetime;
    @JsonProperty("images")
    private List<Image> images;
    @JsonProperty("suggestions")
    private List<Suggestion> suggestions;
    @JsonProperty("modifiers")
    private List<String> modifiers;
    @JsonProperty("secret")
    private String secret;
    @JsonProperty("fail_cause")
    private Object failCause;
    @JsonProperty("countable")
    private Boolean countable;
    @JsonProperty("feedback")
    private Object feedback;
    @JsonProperty("is_plant_probability")
    private Double isPlantProbability;
    @JsonProperty("is_plant")
    private Boolean isPlant;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
