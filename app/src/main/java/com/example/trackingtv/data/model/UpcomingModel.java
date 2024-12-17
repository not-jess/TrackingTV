package com.example.trackingtv.data.model;

public class UpcomingModel {
    String Upcomingtitle;
    int Upcomingimg;

    public UpcomingModel(String upcomingtitle, int upcomingimg) {
        Upcomingtitle = upcomingtitle;
        Upcomingimg = upcomingimg;
    }

    public String getUpcomingtitle() {
        return Upcomingtitle;
    }

    public int getUpcomingimg() {
        return Upcomingimg;
    }
}
