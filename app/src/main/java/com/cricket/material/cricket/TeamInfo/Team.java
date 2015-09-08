
package com.cricket.material.cricket.TeamInfo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
    "ShortName",
    "TeamLogoPath",
    "TeamLogoSmallPath",
    "TeamName",
    "captain",
    "odi",
    "t20",
    "test"
})
public class Team {

    @JsonProperty("ShortName")
    private String ShortName;
    @JsonProperty("TeamLogoPath")
    private String TeamLogoPath;
    @JsonProperty("TeamLogoSmallPath")
    private String TeamLogoSmallPath;
    @JsonProperty("TeamName")
    private String TeamName;
    @JsonProperty("captain")
    private String captain;
    @JsonProperty("odi")
    private String odi;
    @JsonProperty("t20")
    private String t20;
    @JsonProperty("test")
    private String test;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The ShortName
     */
    @JsonProperty("ShortName")
    public String getShortName() {
        return ShortName;
    }

    /**
     * 
     * @param ShortName
     *     The ShortName
     */
    @JsonProperty("ShortName")
    public void setShortName(String ShortName) {
        this.ShortName = ShortName;
    }

    /**
     * 
     * @return
     *     The TeamLogoPath
     */
    @JsonProperty("TeamLogoPath")
    public String getTeamLogoPath() {
        return TeamLogoPath;
    }

    /**
     * 
     * @param TeamLogoPath
     *     The TeamLogoPath
     */
    @JsonProperty("TeamLogoPath")
    public void setTeamLogoPath(String TeamLogoPath) {
        this.TeamLogoPath = TeamLogoPath;
    }

    /**
     * 
     * @return
     *     The TeamLogoSmallPath
     */
    @JsonProperty("TeamLogoSmallPath")
    public String getTeamLogoSmallPath() {
        return TeamLogoSmallPath;
    }

    /**
     * 
     * @param TeamLogoSmallPath
     *     The TeamLogoSmallPath
     */
    @JsonProperty("TeamLogoSmallPath")
    public void setTeamLogoSmallPath(String TeamLogoSmallPath) {
        this.TeamLogoSmallPath = TeamLogoSmallPath;
    }

    /**
     * 
     * @return
     *     The TeamName
     */
    @JsonProperty("TeamName")
    public String getTeamName() {
        return TeamName;
    }

    /**
     * 
     * @param TeamName
     *     The TeamName
     */
    @JsonProperty("TeamName")
    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    /**
     * 
     * @return
     *     The captain
     */
    @JsonProperty("captain")
    public String getCaptain() {
        return captain;
    }

    /**
     * 
     * @param captain
     *     The captain
     */
    @JsonProperty("captain")
    public void setCaptain(String captain) {
        this.captain = captain;
    }

    /**
     * 
     * @return
     *     The odi
     */
    @JsonProperty("odi")
    public String getOdi() {
        return odi;
    }

    /**
     * 
     * @param odi
     *     The odi
     */
    @JsonProperty("odi")
    public void setOdi(String odi) {
        this.odi = odi;
    }

    /**
     * 
     * @return
     *     The t20
     */
    @JsonProperty("t20")
    public String getT20() {
        return t20;
    }

    /**
     * 
     * @param t20
     *     The t20
     */
    @JsonProperty("t20")
    public void setT20(String t20) {
        this.t20 = t20;
    }

    /**
     * 
     * @return
     *     The test
     */
    @JsonProperty("test")
    public String getTest() {
        return test;
    }

    /**
     * 
     * @param test
     *     The test
     */
    @JsonProperty("test")
    public void setTest(String test) {
        this.test = test;
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
