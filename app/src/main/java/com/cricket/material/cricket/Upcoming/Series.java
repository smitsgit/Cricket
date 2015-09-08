
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
    "EndDate",
    "Matches",
    "Participant",
    "SeriesId",
    "SeriesName",
    "StartDate"
})
public class Series {

    @JsonProperty("EndDate")
    private String EndDate;
    @JsonProperty("Matches")
    private List<Match> Matches = new ArrayList<Match>();
    @JsonProperty("Participant")
    private com.cricket.material.cricket.Upcoming.Participant Participant;
    @JsonProperty("SeriesId")
    private String SeriesId;
    @JsonProperty("SeriesName")
    private String SeriesName;
    @JsonProperty("StartDate")
    private String StartDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The EndDate
     */
    @JsonProperty("EndDate")
    public String getEndDate() {
        return EndDate;
    }

    /**
     * 
     * @param EndDate
     *     The EndDate
     */
    @JsonProperty("EndDate")
    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    /**
     * 
     * @return
     *     The Matches
     */
    @JsonProperty("Matches")
    public List<Match> getMatches() {
        return Matches;
    }

    /**
     * 
     * @param Matches
     *     The Matches
     */
    @JsonProperty("Matches")
    public void setMatches(List<Match> Matches) {
        this.Matches = Matches;
    }

    /**
     * 
     * @return
     *     The Participant
     */
    @JsonProperty("Participant")
    public com.cricket.material.cricket.Upcoming.Participant getParticipant() {
        return Participant;
    }

    /**
     * 
     * @param Participant
     *     The Participant
     */
    @JsonProperty("Participant")
    public void setParticipant(com.cricket.material.cricket.Upcoming.Participant Participant) {
        this.Participant = Participant;
    }

    /**
     * 
     * @return
     *     The SeriesId
     */
    @JsonProperty("SeriesId")
    public String getSeriesId() {
        return SeriesId;
    }

    /**
     * 
     * @param SeriesId
     *     The SeriesId
     */
    @JsonProperty("SeriesId")
    public void setSeriesId(String SeriesId) {
        this.SeriesId = SeriesId;
    }

    /**
     * 
     * @return
     *     The SeriesName
     */
    @JsonProperty("SeriesName")
    public String getSeriesName() {
        return SeriesName;
    }

    /**
     * 
     * @param SeriesName
     *     The SeriesName
     */
    @JsonProperty("SeriesName")
    public void setSeriesName(String SeriesName) {
        this.SeriesName = SeriesName;
    }

    /**
     * 
     * @return
     *     The StartDate
     */
    @JsonProperty("StartDate")
    public String getStartDate() {
        return StartDate;
    }

    /**
     * 
     * @param StartDate
     *     The StartDate
     */
    @JsonProperty("StartDate")
    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
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
