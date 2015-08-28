package com.cricket.material.cricket;

import com.cricket.material.cricket.cricketsummary.CricketSummary;

public class OngoingMatchDetail {
    public String matchDetail;
    public String team1Score;
    public String team2Score;
    public String matchResult;

    public OngoingMatchDetail(String matchDetail, String team1Score, String team2Score, String matchResult) {
        this.matchDetail = matchDetail;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.matchResult = matchResult;
    }

    public OngoingMatchDetail(CricketSummary cricketSummary){

    }
}
