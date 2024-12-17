package com.example.myapplication.data.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ui.OverviewModel;

import java.util.ArrayList;

public class OverViewRVAdapter extends RecyclerView.Adapter<OverViewRVAdapter.MyViewHolder> {
Context context;
ArrayList<OverviewModel> overviewModels;
    public OverViewRVAdapter(Context context, ArrayList<OverviewModel> overviewModels){
        this.context = context;
        this.overviewModels = overviewModels;
    }

    @NonNull
    @Override
    public OverViewRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_activity,parent,false);
        return new OverViewRVAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OverViewRVAdapter.MyViewHolder holder, int position) {
    holder.imageView.setImageResource(overviewModels.get(position).getShowImage());
    holder.tvShowName.setText(overviewModels.get(position).getShowName());
    holder.TotalEpisode.setText(overviewModels.get(position).getTotalEpisode());
    }

    @Override
    public int getItemCount() {
        return overviewModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvShowName,TotalEpisode;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ShowThumbnail);
            tvShowName = itemView.findViewById(R.id.ShowTitle);
            TotalEpisode = itemView.findViewById(R.id.TotalEpisode);
        }
    }

}
