package com.example.myapplication.data.model;

public class WatchingModel {
    String ShowTitle;
    String ShowGenre;
    int ShowThumbnail;


    public WatchingModel(String showTitle, String showGenre, int showThumbnail) {
        ShowTitle = showTitle;
        ShowGenre = showGenre;
        ShowThumbnail = showThumbnail;
    }



    public String getShowTitle() {
        return ShowTitle;
    }

    public String getShowGenre() {
        return ShowGenre;
    }

    public int getShowThumbnail() {
        return ShowThumbnail;
    }
}
