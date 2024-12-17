package com.example.trackingtv.models;

import java.util.ArrayList;

public class ShowData {
    private int id;
    private String name;
    private String summary;
    private ArrayList<String> genres;
    private String imageUrl;
    private int totalEpisodes;
    private String tvMazeUrl;

    public ShowData(int id, String name, String summary, ArrayList<String> genres, String imageUrl, int totalEpisodes, String tvMazeUrl) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.genres = genres;
        this.imageUrl = imageUrl;
        this.totalEpisodes = totalEpisodes;
        this.tvMazeUrl = tvMazeUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public String getTvMazeUrl() {
        return tvMazeUrl;
    }

    public void setTvMazeUrl(String tvMazeUrl) {
        this.tvMazeUrl = tvMazeUrl;
    }
}
