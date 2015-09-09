
package com.cricket.material.cricket.SeriesFB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Series",
    "count"
})
public class Past {

    @JsonProperty("Series")
    private List<com.example.android.firebaseexample.Series.Past.Series> Series = new ArrayList<com.example.android.firebaseexample.Series.Past.Series>();
    @JsonProperty("count")
    private long count;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Series
     */
    @JsonProperty("Series")
    public List<com.example.android.firebaseexample.Series.Past.Series> getSeries() {
        return Series;
    }

    /**
     * 
     * @param Series
     *     The Series
     */
    @JsonProperty("Series")
    public void setSeries(List<com.example.android.firebaseexample.Series.Past.Series> Series) {
        this.Series = Series;
    }

    /**
     * 
     * @return
     *     The count
     */
    @JsonProperty("count")
    public long getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    @JsonProperty("count")
    public void setCount(long count) {
        this.count = count;
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
