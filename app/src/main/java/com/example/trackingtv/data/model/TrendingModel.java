package com.example.trackingtv.data.model;

public class TrendingModel {
    String TrendingTtl;
    int TrendingImg;


    public TrendingModel(String trendingTtl, int trendingImg) {
        TrendingTtl = trendingTtl;
        TrendingImg = trendingImg;
    }

    public String getTrendingTtl() {
        return TrendingTtl;
    }

    public int getTrendingImg() {
        return TrendingImg;
    }
}
