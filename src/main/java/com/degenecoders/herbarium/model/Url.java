
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
    "en",
    "global"
})
@Generated("jsonschema2pojo")
public class Url {

    @JsonProperty("sl")
    private Object sl;
    @JsonProperty("en")
    private String en;
    @JsonProperty("global")
    private String global;
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
    public String getEn() {
        return en;
    }

    @JsonProperty("en")
    public void setEn(String en) {
        this.en = en;
    }

    @JsonProperty("global")
    public String getGlobal() {
        return global;
    }

    @JsonProperty("global")
    public void setGlobal(String global) {
        this.global = global;
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
