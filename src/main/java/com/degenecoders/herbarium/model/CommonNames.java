
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
    "sl",
    "en"
})
@Generated("jsonschema2pojo")
public class CommonNames {
    @JsonProperty("sl")
    private Object sl;
    @JsonProperty("en")
    private List<String> en = null;
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
    public List<String> getEn() {
        return en;
    }
    @JsonProperty("en")
    public void setEn(List<String> en) {
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
