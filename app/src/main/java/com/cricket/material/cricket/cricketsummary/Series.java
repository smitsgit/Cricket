
package com.cricket.material.cricket.cricketsummary;

public class Series {

    private String SeriesId;
    private String SeriesName;
    private String StartDate;
    private String EndDate;
    private com.cricket.material.cricket.cricketsummary.Participant Participant;
    private com.cricket.material.cricket.cricketsummary.Schedule Schedule;

    public String getSeriesId() {
        return SeriesId;
    }


    public void setSeriesId(String SeriesId) {
        this.SeriesId = SeriesId;
    }


    public String getSeriesName() {
        return SeriesName;
    }


    public void setSeriesName(String SeriesName) {
        this.SeriesName = SeriesName;
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

    public com.cricket.material.cricket.cricketsummary.Participant getParticipant() {
        return Participant;
    }


    public void setParticipant(com.cricket.material.cricket.cricketsummary.Participant Participant) {
        this.Participant = Participant;
    }


    public com.cricket.material.cricket.cricketsummary.Schedule getSchedule() {
        return Schedule;
    }


    public void setSchedule(com.cricket.material.cricket.cricketsummary.Schedule Schedule) {
        this.Schedule = Schedule;
    }


}
