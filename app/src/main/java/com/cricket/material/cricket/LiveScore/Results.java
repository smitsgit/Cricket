
package com.cricket.material.cricket.LiveScore;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private List<Scorecard> Scorecard = new ArrayList<>();

    public List<Scorecard> getScorecard() {
        return Scorecard;
    }


    public void setScorecard(List<Scorecard> scorecard) {
        this.Scorecard = scorecard;
    }

}
