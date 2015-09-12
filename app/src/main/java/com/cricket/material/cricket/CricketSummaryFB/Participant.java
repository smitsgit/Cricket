
package com.cricket.material.cricket.CricketSummaryFB;

import android.os.Parcel;
import android.os.Parcelable;

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
public class Participant implements Parcelable {

    @JsonProperty("Team")
    private List<com.cricket.material.cricket.CricketSummaryFB.Team> Team = new ArrayList<com.cricket.material.cricket.CricketSummaryFB.Team>();
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
    public List<com.cricket.material.cricket.CricketSummaryFB.Team> getTeam() {
        return Team;
    }

    /**
     * 
     * @param Team
     *     The Team
     */
    @JsonProperty("Team")
    public void setTeam(List<com.cricket.material.cricket.CricketSummaryFB.Team> Team) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(Team);
        dest.writeString(this.mlevel);
        dest.writeString(this.mtype);
    }

    public Participant() {
    }

    protected Participant(Parcel in) {
        this.Team = in.createTypedArrayList(com.cricket.material.cricket.CricketSummaryFB.Team.CREATOR);
        this.mlevel = in.readString();
        this.mtype = in.readString();
    }

    public static final Parcelable.Creator<Participant> CREATOR = new Parcelable.Creator<Participant>() {
        public Participant createFromParcel(Parcel source) {
            return new Participant(source);
        }

        public Participant[] newArray(int size) {
            return new Participant[size];
        }
    };
}
