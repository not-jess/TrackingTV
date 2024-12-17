package com.example.trackingtv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackingtv.R;
import com.example.trackingtv.adapters.ShowAdapter;
import com.example.trackingtv.adapters.TrendingShowAdapter;
import com.example.trackingtv.data.model.TrendingModel;
import com.example.trackingtv.data.model.TrendingRVAdapter;
import com.example.trackingtv.data.model.UpcomingModel;
import com.example.trackingtv.data.model.UpcomingRVAdapter;
import com.example.trackingtv.models.ShowData;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

//    RecyclerView rvTrending,rvUpcoming;
//    LinearLayoutManager linearLayoutManager;
//    TrendingRVAdapter trendingRvAdapter;
//    UpcomingRVAdapter upcomingRVAdapter;
//    ArrayList<TrendingModel> trendingModels;
//    ArrayList<UpcomingModel> upcomingModels;

    private RecyclerView homeWatchingRV, homeTrendingRV;
    private ShowAdapter showAdapter;
    private TrendingShowAdapter trendingShowAdapter;
    private ArrayList<ShowData> showList = new ArrayList<>();
    private ArrayList<ShowData> trendingShowList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        trendingModels = new ArrayList<>();
//        upcomingModels = new ArrayList<>();

//        isiTrending();
//        isiUpcoming();
        prepareData();

        homeWatchingRV = findViewById(R.id.homeWatchingRV);
        showAdapter = new ShowAdapter(showList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        homeWatchingRV.setLayoutManager(layoutManager);
        homeWatchingRV.setAdapter(showAdapter);

        homeTrendingRV = findViewById(R.id.homeTrendingRV);
        trendingShowAdapter = new TrendingShowAdapter(trendingShowList);
        homeTrendingRV.setLayoutManager(new LinearLayoutManager(this));
        homeTrendingRV.setAdapter(trendingShowAdapter);


//        rvTrending = findViewById(R.id.homeWatchingRV);
//        LinearLayoutManager LinearLayoutManager = new LinearLayoutManager(HomePage.this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false);
//        trendingRvAdapter = new TrendingRVAdapter(HomePage.this, trendingModels);
//        rvTrending.setLayoutManager(LinearLayoutManager);
//        rvTrending.setAdapter(trendingRvAdapter);
////
//        rvUpcoming = findViewById(R.id.homeTrendingRV);
//        linearLayoutManager = new LinearLayoutManager(HomePage.this, androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL, false);
//        upcomingRVAdapter = new UpcomingRVAdapter(HomePage.this, upcomingModels);
//        rvUpcoming.setLayoutManager(linearLayoutManager);
//        rvUpcoming.setAdapter(upcomingRVAdapter);


        Button button = findViewById(R.id.toUser);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ProfilePage.class);
                startActivity(intent);
            }
        });

    };
//    public void isiTrending(){
//        trendingModels.add(new TrendingModel("Title1",R.drawable.imagetv1));
//        trendingModels.add(new TrendingModel("Title2",R.drawable.imagetv1));
//        trendingModels.add(new TrendingModel("Title3",R.drawable.imagetv1));
//        trendingModels.add(new TrendingModel("Title4",R.drawable.imagetv1));
//        trendingModels.add(new TrendingModel("Title5",R.drawable.imagetv1));
//    }
//    public void isiUpcoming() {
//        upcomingModels.add(new UpcomingModel("Title1", R.drawable.imagetv1));
//        upcomingModels.add(new UpcomingModel("Title2", R.drawable.imagetv1));
//        upcomingModels.add(new UpcomingModel("Title3", R.drawable.imagetv1));
//        upcomingModels.add(new UpcomingModel("Title4", R.drawable.imagetv1));
//        upcomingModels.add(new UpcomingModel("Title5", R.drawable.imagetv1));
//
//    }
        private void prepareData() {
            // dummy data
            ArrayList<String> genres = new ArrayList<>();
            genres.add("horror");
            genres.add("sci-fi");
            showList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            showList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            showList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            showList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            showList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            showList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            showList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            showList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            trendingShowList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            trendingShowList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));
            trendingShowList.add(new ShowData(1, "Lost", "Interesting show", genres, "https://static.tvmaze.com/uploads/images/medium_portrait/81/202627.jpg", 100, "https://api.tvmaze.com/shows/1"));

        }
    }
