
package com.cricket.material.cricket.cricketsummary;

import java.util.ArrayList;
import java.util.List;


public class Results {

    private List<com.cricket.material.cricket.cricketsummary.Series> Series = new ArrayList<com.cricket.material.cricket.cricketsummary.Series>();


    public List<com.cricket.material.cricket.cricketsummary.Series> getSeries() {
        return Series;
    }


    public void setSeries(List<com.cricket.material.cricket.cricketsummary.Series> Series) {
        this.Series = Series;
    }


}
