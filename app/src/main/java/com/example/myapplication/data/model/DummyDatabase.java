package com.example.myapplication.data.model;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.R;
import java.util.ArrayList;
public class DummyDatabase
{
    Context context;
    ArrayList<TrendingModel> trendingModels;
    ArrayList<UpcomingModel> upcomingModels;

    public  ArrayList<UpcomingModel> getUpcomingModels() {
        return upcomingModels;
    }
    public ArrayList<TrendingModel> getTrendingModels() {
        return trendingModels;
    }
    public void isiTrending(){
        trendingModels.add(new TrendingModel("Title1",R.drawable.squarebuttondifferentcolor));
        trendingModels.add(new TrendingModel("Title2",R.drawable.squarebuttondifferentcolor));
        trendingModels.add(new TrendingModel("Title3",R.drawable.squarebuttondifferentcolor));
    }
    public void isiUpcoming() {
        upcomingModels.add(new UpcomingModel("Title1", R.drawable.squarebuttondifferentcolor));
        upcomingModels.add(new UpcomingModel("Title2", R.drawable.squarebuttondifferentcolor));
    }



}
