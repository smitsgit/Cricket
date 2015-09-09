
package com.cricket.material.cricket.CricketSummaryFB;

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
    "Team",
    "mlevel",
    "mtype"
})
public class Participant {

    @JsonProperty("Team")
    private List<com.example.android.firebaseexample.Series.Past.Team> Team = new ArrayList<com.example.android.firebaseexample.Series.Past.Team>();
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
    public List<com.example.android.firebaseexample.Series.Past.Team> getTeam() {
        return Team;
    }

    /**
     * 
     * @param Team
     *     The Team
     */
    @JsonProperty("Team")
    public void setTeam(List<com.example.android.firebaseexample.Series.Past.Team> Team) {
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
