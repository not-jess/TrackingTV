package com.example.trackingtv.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackingtv.R;
import com.example.trackingtv.models.ShowData;
import com.example.trackingtv.ui.SeriesDescription;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TrendingShowAdapter extends RecyclerView.Adapter<TrendingShowAdapter.TrendingShowHolder> {
    private Context activityContext;
    private List<ShowData> trendingShowList;

    public TrendingShowAdapter(List<ShowData> dataTrendingShow) {
        trendingShowList = dataTrendingShow;
    }

    @NonNull
    @Override
    public TrendingShowAdapter.TrendingShowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(activityContext);
        View layoutView = inflater.inflate(R.layout.item_trending_show, parent, false);
        TrendingShowHolder holder = new TrendingShowHolder(layoutView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingShowAdapter.TrendingShowHolder holder, int position) {
        ShowData show = trendingShowList.get(position);

        String name = show.getName();
        holder.trendingShowNameTV.setText(name);

        String summary = show.getSummary();
        holder.trendingShowSummaryTV.setText(summary);

        ArrayList<String> genres = new ArrayList<>();
        genres = show.getGenres();
        String genreString = "";
        for (int i = 0; i < genres.size(); i++) {
            genreString += genres.get(i);
            if (i != genres.size() - 1) {
                genreString += ", ";
            }
        }
        holder.trendingShowGenresTV.setText(genreString);

        Picasso.get()
                .load(show.getImageUrl())
                .placeholder(R.drawable.baseline_downloading_24) // Optional placeholder
                .error(R.drawable.baseline_error_24)           // Optional error fallback
                .into(holder.trendingShowImageIV);

        holder.trendingShowContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveIntent = new Intent(activityContext, SeriesDescription.class);
                moveIntent.putExtra("name", show.getName());
                moveIntent.putExtra("image", show.getImageUrl());
                moveIntent.putExtra("summary", show.getSummary());

                activityContext.startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trendingShowList.size();
    }

    public class TrendingShowHolder extends RecyclerView.ViewHolder {
        TextView trendingShowNameTV;
        TextView trendingShowSummaryTV;
        TextView trendingShowGenresTV;
        ImageView trendingShowImageIV;
        ConstraintLayout trendingShowContainer;
        public TrendingShowHolder(@NonNull View itemView) {
            super(itemView);
            trendingShowNameTV = itemView.findViewById(R.id.trendingShowNameTV);
            trendingShowSummaryTV = itemView.findViewById(R.id.trendingShowSummaryTV);
            trendingShowGenresTV = itemView.findViewById(R.id.trendingShowGenresTV);
            trendingShowImageIV = itemView.findViewById(R.id.trendingShowImageIV);
            trendingShowContainer = itemView.findViewById(R.id.trendingShowContainer);
        }
    }
}
