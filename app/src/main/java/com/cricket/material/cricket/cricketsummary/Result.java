
package com.cricket.material.cricket.cricketsummary;

import java.util.ArrayList;
import java.util.List;


public class Result {

    private String by;
    private String how;
    private String isdl;
    private String isff;
    private String isso;
    private List<Team__> Team = new ArrayList<Team__>();
    private String Date;



    public String getBy() {
        return by;
    }


    public void setBy(String by) {
        this.by = by;
    }


    public String getHow() {
        return how;
    }


    public void setHow(String how) {
        this.how = how;
    }


    public String getIsdl() {
        return isdl;
    }


    public void setIsdl(String isdl) {
        this.isdl = isdl;
    }


    public String getIsff() {
        return isff;
    }


    public void setIsff(String isff) {
        this.isff = isff;
    }


    public String getIsso() {
        return isso;
    }


    public void setIsso(String isso) {
        this.isso = isso;
    }


    public List<Team__> getTeam() {
        return Team;
    }


    public void setTeam(List<Team__> Team) {
        this.Team = Team;
    }


    public String getDate() {
        return Date;
    }


    public void setDate(String Date) {
        this.Date = Date;
    }


}
