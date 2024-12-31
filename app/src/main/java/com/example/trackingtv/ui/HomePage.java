package com.example.trackingtv.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
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
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomePage extends AppCompatActivity {

    private RecyclerView homeWatchingRV, homeTrendingRV;
    private ShowAdapter showAdapter;
    private TrendingShowAdapter trendingShowAdapter;
    private ArrayList<ShowData> showList = new ArrayList<>();
    private ArrayList<ShowData> trendingShowList = new ArrayList<>();

    SharedPreferences userPrefData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        userPrefData = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

        fetchTrendingShows();

        homeWatchingRV = findViewById(R.id.homeWatchingRV);
        showAdapter = new ShowAdapter(showList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        homeWatchingRV.setLayoutManager(layoutManager);
        homeWatchingRV.setAdapter(showAdapter);

        homeTrendingRV = findViewById(R.id.homeTrendingRV);
        trendingShowAdapter = new TrendingShowAdapter(trendingShowList);
        homeTrendingRV.setLayoutManager(new LinearLayoutManager(this));
        homeTrendingRV.setAdapter(trendingShowAdapter);


        Button button = findViewById(R.id.toUser);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ProfilePage.class);
                startActivity(intent);
            }
        });

    };

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

        private void fetchTrendingShows() {
            OkHttpClient client = new OkHttpClient();
            String url = "https://api.tvmaze.com/shows";

            Request request = new Request.Builder().url(url).build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if(response.isSuccessful()) {
                        String responseBody = response.body().string();

                        Gson gson = new Gson();
                        Type listType = new TypeToken<ArrayList<ShowData>>() {}.getType();
                        ArrayList<ShowData> tvShowList = new ArrayList<>();

                        JsonArray jsonArray = JsonParser.parseString(responseBody).getAsJsonArray();

                        for(JsonElement element : jsonArray) {
                            JsonObject jsonObject = element.getAsJsonObject();
                            int id = jsonObject.get("id").getAsInt();
                            String name = jsonObject.get("name").getAsString();
                            String summary = jsonObject.has("summary") ? jsonObject.get("summary").getAsString() : "No Summary Available";
                            ArrayList<String> genres = new Gson().fromJson(jsonObject.getAsJsonArray("genres"), new TypeToken<ArrayList<String>>() {}.getType());
                            String imageUrl = jsonObject.getAsJsonObject("image").get("medium").getAsString();
                            int totalEpisodes = jsonObject.has("weight") ? jsonObject.get("weight").getAsInt() : 0;
                            String tvMazeLink = jsonObject.get("url").getAsString();

                            tvShowList.add(new ShowData(id, name, summary, genres, imageUrl, totalEpisodes, tvMazeLink));
                        }

                        runOnUiThread(()->updateRecyclerView(tvShowList));
                    }
                }
            });
        }

        private void updateRecyclerView(ArrayList<ShowData> newTVShows) {
            showList.clear();
            showList.addAll(newTVShows);
            trendingShowList.addAll(newTVShows);
            showAdapter.notifyDataSetChanged();
        }
    }
