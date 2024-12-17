package com.example.trackingtv.data.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trackingtv.R;


import java.util.ArrayList;

public class WatchingRVAdapter extends RecyclerView.Adapter<WatchingRVAdapter.MyViewHolder>{
    Context context;
    ArrayList<WatchingModel> watchingModels;
    public WatchingRVAdapter(Context context, ArrayList<WatchingModel> watchingModels){
        this.context = context;
        this.watchingModels = watchingModels;
    }

    @NonNull
    @Override
    public WatchingRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_watching,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchingRVAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(watchingModels.get(position).getShowThumbnail());
        holder.tvShowTitle.setText(watchingModels.get(position).getShowTitle());
        holder.tvShowGenre.setText(watchingModels.get(position).getShowGenre());
    }

    @Override
    public int getItemCount() {
        return watchingModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvShowTitle,tvShowGenre;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ShowThumbnail);
            tvShowTitle = itemView.findViewById(R.id.ShowTitle);
            tvShowGenre = itemView.findViewById(R.id.ShowGenre);
        }
    }
}
