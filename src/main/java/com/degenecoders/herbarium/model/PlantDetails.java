
package com.degenecoders.herbarium.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "common_names",
    "url",
    "wiki_description",
    "edible_parts",
    "gbif_id",
    "propagation_methods",
    "scientific_name",
    "structured_name"
})
@Generated("jsonschema2pojo")
public class PlantDetails {

    @JsonProperty("common_names")
    private CommonNames commonNames;
    @JsonProperty("url")
    private Url url;
    @JsonProperty("wiki_description")
    private WikiDescription wikiDescription;
    @JsonProperty("edible_parts")
    private List<String> edibleParts = null;
    @JsonProperty("gbif_id")
    private String gbifId;
    @JsonProperty("propagation_methods")
    private Object propagationMethods;
    @JsonProperty("scientific_name")
    private String scientificName;
    @JsonProperty("structured_name")
    private StructuredName structuredName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("common_names")
    public CommonNames getCommonNames() {
        return commonNames;
    }

    @JsonProperty("common_names")
    public void setCommonNames(CommonNames commonNames) {
        this.commonNames = commonNames;
    }

    @JsonProperty("url")
    public Url getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(Url url) {
        this.url = url;
    }

    @JsonProperty("wiki_description")
    public WikiDescription getWikiDescription() {
        return wikiDescription;
    }

    @JsonProperty("wiki_description")
    public void setWikiDescription(WikiDescription wikiDescription) {
        this.wikiDescription = wikiDescription;
    }

    @JsonProperty("edible_parts")
    public List<String> getEdibleParts() {
        return edibleParts;
    }

    @JsonProperty("edible_parts")
    public void setEdibleParts(List<String> edibleParts) {
        this.edibleParts = edibleParts;
    }

    @JsonProperty("gbif_id")
    public String getGbifId() {
        return gbifId;
    }

    @JsonProperty("gbif_id")
    public void setGbifId(String gbifId) {
        this.gbifId = gbifId;
    }

    @JsonProperty("propagation_methods")
    public Object getPropagationMethods() {
        return propagationMethods;
    }

    @JsonProperty("propagation_methods")
    public void setPropagationMethods(Object propagationMethods) {
        this.propagationMethods = propagationMethods;
    }

    @JsonProperty("scientific_name")
    public String getScientificName() {
        return scientificName;
    }

    @JsonProperty("scientific_name")
    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    @JsonProperty("structured_name")
    public StructuredName getStructuredName() {
        return structuredName;
    }

    @JsonProperty("structured_name")
    public void setStructuredName(StructuredName structuredName) {
        this.structuredName = structuredName;
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
