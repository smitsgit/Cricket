
package com.cricket.material.cricket.cricketsummary;

import java.util.ArrayList;
import java.util.List;


public class Schedule {

    private List<com.cricket.material.cricket.cricketsummary.Match> Match = new ArrayList<com.cricket.material.cricket.cricketsummary.Match>();

    public List<com.cricket.material.cricket.cricketsummary.Match> getMatch() {
        return Match;
    }


    public void setMatch(List<com.cricket.material.cricket.cricketsummary.Match> Match) {
        this.Match = Match;
    }



}
