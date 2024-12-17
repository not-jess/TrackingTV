package com.example.myapplication.ui;

public class OverviewModel {
    String ShowName;
    String TotalEpisode;
    int ShowImage;


    public OverviewModel(String showName, String dateWatched, int showImage) {
        ShowName = showName;
        TotalEpisode = dateWatched;
        ShowImage = showImage;
    }


    public String getShowName() {
        return ShowName;
    }

    public String getTotalEpisode() {
        return TotalEpisode;
    }

    public int getShowImage() {
        return ShowImage;
    }
}
