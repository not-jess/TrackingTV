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

public class CompletedRVAdapter extends RecyclerView.Adapter<CompletedRVAdapter.MyViewHolder> {
        Context context;
        ArrayList<CompletedModel> completedModels;
        public CompletedRVAdapter(Context context, ArrayList<CompletedModel> completedModels){
            this.context = context;
            this.completedModels = completedModels;
        }


    @NonNull
    @Override
    public CompletedRVAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater inflater = LayoutInflater.from(context);
       View view = inflater.inflate(R.layout.recyclerview_completedwatching,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompletedRVAdapter.MyViewHolder holder, int position) {
    holder.imageView.setImageResource(completedModels.get(position).getShowThumbnail());
    holder.tvShowTitle.setText(completedModels.get(position).getShowTitle());
    holder.tvShowGenre.setText(completedModels.get(position).getShowGenre());
    }

    @Override
    public int getItemCount() {
        return completedModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
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
