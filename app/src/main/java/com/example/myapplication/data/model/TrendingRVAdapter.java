package com.example.myapplication.data.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.HomePage;
import com.example.myapplication.ui.SeriesDescription;

import java.util.ArrayList;

public class TrendingRVAdapter extends RecyclerView.Adapter<TrendingRVAdapter.Myholder> {
    ArrayList<TrendingModel> trendingModels;
    Context context;
    public TrendingRVAdapter(Context context, ArrayList<TrendingModel>trendingModels) {
        this.context = context;
        this.trendingModels = trendingModels;
    }


    @NonNull
    @Override
    public TrendingRVAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_trending,parent,false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingRVAdapter.Myholder holder, int position) {
        holder.tvTitle.setText(trendingModels.get(position).getTrendingTtl());
        holder.ivImage.setImageResource(trendingModels.get(position).getTrendingImg());

        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    Intent intent;
                intent = new Intent(context, SeriesDescription.class);
                intent.putExtra("Title",trendingModels.get(currentPosition).getTrendingTtl());
                intent.putExtra("Image",trendingModels.get(currentPosition).getTrendingImg());
                context.startActivity(intent);}
            }
        });
    }

    @Override
    public int getItemCount() {
        return trendingModels.size();
    }
    public static class Myholder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivImage;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.TrendingTitle);
            ivImage = itemView.findViewById(R.id.TrendingImage);
        }
    }



}
