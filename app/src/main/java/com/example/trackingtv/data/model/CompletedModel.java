package com.example.trackingtv.data.model;

public class CompletedModel {
    String ShowTitle;
    String ShowGenre;
    int ShowThumbnail;

    public CompletedModel(String title, String genre, int thumbnail) {
        ShowTitle = title;
        ShowGenre = genre;
        ShowThumbnail = thumbnail;
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
