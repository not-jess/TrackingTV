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

public class UpcomingRVAdapter extends RecyclerView.Adapter<UpcomingRVAdapter.Myholder> {
    Context context;
    ArrayList<UpcomingModel> upcomingModels;

    public UpcomingRVAdapter(Context context, ArrayList<UpcomingModel> upcomingModels) {
        this.context = context;
        this.upcomingModels = upcomingModels;
    }

    @NonNull
    @Override
    public UpcomingRVAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_upcoming, parent, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingRVAdapter.Myholder holder, int position) {
        holder.tvTitle.setText(upcomingModels.get(position).getUpcomingtitle());
        holder.ivImage.setImageResource(upcomingModels.get(position).getUpcomingimg());
    }

    @Override
    public int getItemCount() {
        return upcomingModels.size();
    }
    public static class Myholder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivImage;
        public Myholder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.UpcomingTitle);
            ivImage = itemView.findViewById(R.id.UpcomingImage);
        }
    }
}
