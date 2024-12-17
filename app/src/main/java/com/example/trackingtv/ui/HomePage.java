package com.example.trackingtv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackingtv.R;
import com.example.trackingtv.data.model.TrendingModel;
import com.example.trackingtv.data.model.TrendingRVAdapter;
import com.example.trackingtv.data.model.UpcomingModel;
import com.example.trackingtv.data.model.UpcomingRVAdapter;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    RecyclerView rvTrending,rvUpcoming;
    LinearLayoutManager linearLayoutManager;
    TrendingRVAdapter trendingRvAdapter;
    UpcomingRVAdapter upcomingRVAdapter;
    ArrayList<TrendingModel> trendingModels;
    ArrayList<UpcomingModel> upcomingModels;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        trendingModels = new ArrayList<>();
        upcomingModels = new ArrayList<>();

        isiTrending();
        isiUpcoming();


        rvTrending = findViewById(R.id.trendingrv);
        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(HomePage.this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false);
        trendingRvAdapter = new TrendingRVAdapter(HomePage.this, trendingModels);
        rvTrending.setLayoutManager(LinearLayoutManager);
        rvTrending.setAdapter(trendingRvAdapter);
//
        rvUpcoming = findViewById(R.id.upcomingrv);
        linearLayoutManager = new LinearLayoutManager(HomePage.this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false);
        upcomingRVAdapter = new UpcomingRVAdapter(HomePage.this, upcomingModels);
        rvUpcoming.setLayoutManager(linearLayoutManager);
        rvUpcoming.setAdapter(upcomingRVAdapter);


        Button button = findViewById(R.id.toUser);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ProfilePage.class);
                startActivity(intent);
            }
        });

    };
    public void isiTrending(){
        trendingModels.add(new TrendingModel("Title1",R.drawable.imagetv1));
        trendingModels.add(new TrendingModel("Title2",R.drawable.imagetv1));
        trendingModels.add(new TrendingModel("Title3",R.drawable.imagetv1));
        trendingModels.add(new TrendingModel("Title4",R.drawable.imagetv1));
        trendingModels.add(new TrendingModel("Title5",R.drawable.imagetv1));
    }
    public void isiUpcoming() {
        upcomingModels.add(new UpcomingModel("Title1", R.drawable.imagetv1));
        upcomingModels.add(new UpcomingModel("Title2", R.drawable.imagetv1));
        upcomingModels.add(new UpcomingModel("Title3", R.drawable.imagetv1));
        upcomingModels.add(new UpcomingModel("Title4", R.drawable.imagetv1));
        upcomingModels.add(new UpcomingModel("Title5", R.drawable.imagetv1));

    }
    }
