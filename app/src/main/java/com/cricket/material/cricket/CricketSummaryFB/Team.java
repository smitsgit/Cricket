
package com.cricket.material.cricket.CricketSummaryFB;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Name",
    "teamid"
})
public class Team implements Parcelable {

    @JsonProperty("Name")
    private String Name;
    @JsonProperty("teamid")
    private String teamid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The Name
     */
    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name
     *     The Name
     */
    @JsonProperty("Name")
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * 
     * @return
     *     The teamid
     */
    @JsonProperty("teamid")
    public String getTeamid() {
        return teamid;
    }

    /**
     * 
     * @param teamid
     *     The teamid
     */
    @JsonProperty("teamid")
    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeString(this.teamid);
    }

    public Team() {
    }

    protected Team(Parcel in) {
        this.Name = in.readString();
        this.teamid = in.readString();
    }

    public static final Parcelable.Creator<Team> CREATOR = new Parcelable.Creator<Team>() {
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
