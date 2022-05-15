
package com.degenecoders.herbarium.model;

import java.util.HashMap;
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
    "sl",
    "en"
})
@Generated("jsonschema2pojo")
public class WikiDescription {

    @JsonProperty("sl")
    private Object sl;
    @JsonProperty("en")
    private En en;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sl")
    public Object getSl() {
        return sl;
    }

    @JsonProperty("sl")
    public void setSl(Object sl) {
        this.sl = sl;
    }

    @JsonProperty("en")
    public En getEn() {
        return en;
    }

    @JsonProperty("en")
    public void setEn(En en) {
        this.en = en;
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
