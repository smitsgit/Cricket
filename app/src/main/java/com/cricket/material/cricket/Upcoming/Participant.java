
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
    "Team",
    "mlevel",
    "mtype"
})
public class Participant {

    @JsonProperty("Team")
    private List<com.cricket.material.cricket.Upcoming.Team> Team = new ArrayList<com.cricket.material.cricket.Upcoming.Team>();
    @JsonProperty("mlevel")
    private String mlevel;
    @JsonProperty("mtype")
    private String mtype;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Team
     */
    @JsonProperty("Team")
    public List<com.cricket.material.cricket.Upcoming.Team> getTeam() {
        return Team;
    }

    /**
     * 
     * @param Team
     *     The Team
     */
    @JsonProperty("Team")
    public void setTeam(List<com.cricket.material.cricket.Upcoming.Team> Team) {
        this.Team = Team;
    }

    /**
     * 
     * @return
     *     The mlevel
     */
    @JsonProperty("mlevel")
    public String getMlevel() {
        return mlevel;
    }

    /**
     * 
     * @param mlevel
     *     The mlevel
     */
    @JsonProperty("mlevel")
    public void setMlevel(String mlevel) {
        this.mlevel = mlevel;
    }

    /**
     * 
     * @return
     *     The mtype
     */
    @JsonProperty("mtype")
    public String getMtype() {
        return mtype;
    }

    /**
     * 
     * @param mtype
     *     The mtype
     */
    @JsonProperty("mtype")
    public void setMtype(String mtype) {
        this.mtype = mtype;
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
