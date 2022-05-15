
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
    "value",
    "citation",
    "license_name",
    "license_url"
})
@Generated("jsonschema2pojo")
public class En {

    @JsonProperty("value")
    private String value;
    @JsonProperty("citation")
    private String citation;
    @JsonProperty("license_name")
    private String licenseName;
    @JsonProperty("license_url")
    private String licenseUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("citation")
    public String getCitation() {
        return citation;
    }

    @JsonProperty("citation")
    public void setCitation(String citation) {
        this.citation = citation;
    }

    @JsonProperty("license_name")
    public String getLicenseName() {
        return licenseName;
    }

    @JsonProperty("license_name")
    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    @JsonProperty("license_url")
    public String getLicenseUrl() {
        return licenseUrl;
    }

    @JsonProperty("license_url")
    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
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
