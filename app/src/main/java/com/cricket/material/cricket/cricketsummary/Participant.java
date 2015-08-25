
package com.cricket.material.cricket.cricketsummary;

import java.util.ArrayList;
import java.util.List;


public class Participant {

    private String mlevel;
    private String mtype;
    private List<com.cricket.material.cricket.cricketsummary.Team> Team = new ArrayList<com.cricket.material.cricket.cricketsummary.Team>();



    public String getMlevel() {
        return mlevel;
    }


    public void setMlevel(String mlevel) {
        this.mlevel = mlevel;
    }


    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }


    public List<com.cricket.material.cricket.cricketsummary.Team> getTeam() {
        return Team;
    }


    public void setTeam(List<com.cricket.material.cricket.cricketsummary.Team> Team) {
        this.Team = Team;
    }


}
