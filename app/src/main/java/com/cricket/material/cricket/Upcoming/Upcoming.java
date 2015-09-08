
package com.cricket.material.cricket.Upcoming;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
    "Series"
})
public class Upcoming {

    @JsonProperty("Series")
    private List<com.cricket.material.cricket.Upcoming.Series> Series = new ArrayList<com.cricket.material.cricket.Upcoming.Series>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Series
     */
    @JsonProperty("Series")
    public List<com.cricket.material.cricket.Upcoming.Series> getSeries() {
        return Series;
    }

    /**
     * 
     * @param Series
     *     The Series
     */
    @JsonProperty("Series")
    public void setSeries(List<com.cricket.material.cricket.Upcoming.Series> Series) {
        this.Series = Series;
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
