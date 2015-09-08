
package com.cricket.material.cricket.TeamInfo;

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
    "Team"
})
public class TeamInfo {

    @JsonProperty("Team")
    private List<com.cricket.material.cricket.TeamInfo.Team> Team = new ArrayList<com.cricket.material.cricket.TeamInfo.Team>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Team
     */
    @JsonProperty("Team")
    public List<com.cricket.material.cricket.TeamInfo.Team> getTeam() {
        return Team;
    }

    /**
     * 
     * @param Team
     *     The Team
     */
    @JsonProperty("Team")
    public void setTeam(List<com.cricket.material.cricket.TeamInfo.Team> Team) {
        this.Team = Team;
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
