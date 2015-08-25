
package com.cricket.material.cricket.cricketsummary;

import java.util.ArrayList;
import java.util.List;


public class Match {

    private String group;
    private String matchid;
    private String mtype;
    private String stage;
    private String status;
    private String MatchNo;
    private com.cricket.material.cricket.cricketsummary.Venue Venue;
    private String StartDate;
    private String EndDate;
    private String MatchTimeSpan;
    private List<Team_> Team = new ArrayList<Team_>();
    private com.cricket.material.cricket.cricketsummary.Result Result;


    public String getGroup() {
        return group;
    }


    public void setGroup(String group) {
        this.group = group;
    }


    public String getMatchid() {
        return matchid;
    }


    public void setMatchid(String matchid) {
        this.matchid = matchid;
    }


    public String getMtype() {
        return mtype;
    }


    public void setMtype(String mtype) {
        this.mtype = mtype;
    }


    public String getStage() {
        return stage;
    }


    public void setStage(String stage) {
        this.stage = stage;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getMatchNo() {
        return MatchNo;
    }


    public void setMatchNo(String MatchNo) {
        this.MatchNo = MatchNo;
    }


    public com.cricket.material.cricket.cricketsummary.Venue getVenue() {
        return Venue;
    }


    public void setVenue(com.cricket.material.cricket.cricketsummary.Venue Venue) {
        this.Venue = Venue;
    }


    public String getStartDate() {
        return StartDate;
    }


    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }


    public String getEndDate() {
        return EndDate;
    }


    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }


    public String getMatchTimeSpan() {
        return MatchTimeSpan;
    }


    public void setMatchTimeSpan(String MatchTimeSpan) {
        this.MatchTimeSpan = MatchTimeSpan;
    }


    public List<Team_> getTeam() {
        return Team;
    }


    public void setTeam(List<Team_> Team) {
        this.Team = Team;
    }


    public com.cricket.material.cricket.cricketsummary.Result getResult() {
        return Result;
    }


    public void setResult(com.cricket.material.cricket.cricketsummary.Result Result) {
        this.Result = Result;
    }


}
