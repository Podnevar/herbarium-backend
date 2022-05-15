
package com.degenecoders.herbarium.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "images",
    "modifiers",
    "plant_details",
    "plant_languages"
})
@Generated("jsonschema2pojo")
public class PlantidRequest {

    @JsonProperty("images")
    private List<String> images;
    @JsonProperty("modifiers")
    private List<String> modifiers;
    @JsonProperty("plant_details")
    private List<String> plantDetails;
    @JsonProperty("plant_languages")
    private List<String> plantLanguages;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
