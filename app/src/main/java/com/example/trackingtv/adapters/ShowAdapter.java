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

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ShowHolder> {

    private Context activityContext;
    private List<ShowData> showList;

    public ShowAdapter(List<ShowData> dataShow) {
        showList = dataShow;
    }

    @NonNull
    @Override
    public ShowAdapter.ShowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(activityContext);
        View layoutView = inflater.inflate(R.layout.item_show, parent, false);
        ShowHolder holder = new ShowHolder(layoutView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ShowHolder holder, int position) {
        ShowData show = showList.get(position);
        String name = show.getName();
        holder.showNameTV.setText(name);
        Picasso.get()
                .load(show.getImageUrl())
                .placeholder(R.drawable.baseline_downloading_24) // Optional placeholder
                .error(R.drawable.baseline_error_24)           // Optional error fallback
                .into(holder.showImageIV);

        holder.showContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveIntent = new Intent(activityContext, SeriesDescription.class);
                moveIntent.putExtra("name", show.getName());
                moveIntent.putExtra("summary", show.getSummary());
                ArrayList<String> genres = new ArrayList<>();
                genres = show.getGenres();
                String genreString = "";
                for (int i = 0; i < genres.size(); i++) {
                    genreString += genres.get(i);
                    if (i != genres.size() - 1) {
                        genreString += ", ";
                    }
                }
                moveIntent.putExtra("genres", genreString);
                moveIntent.putExtra("image", show.getImageUrl());

                activityContext.startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return showList.size();
    }

    public class ShowHolder extends RecyclerView.ViewHolder {
        TextView showNameTV;
        ImageView showImageIV;
        ConstraintLayout showContainer;
        public ShowHolder(@NonNull View itemView) {
            super(itemView);
            showNameTV = itemView.findViewById(R.id.showNameTV);
            showImageIV = itemView.findViewById(R.id.showImageIV);
            showContainer = itemView.findViewById(R.id.showContainer);
        }
    }
}
