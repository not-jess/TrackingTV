package com.example.trackingtv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.trackingtv.R;
import com.squareup.picasso.Picasso;

public class SeriesDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_series_description);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);




            return insets;

        });
        Button backbtn =findViewById(R.id.backtohome);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeriesDescription.this, HomePage.class);
                startActivity(intent);
            }
        });
        String name = getIntent().getStringExtra("name");
        String summary = getIntent().getStringExtra("summary");
        String genre = getIntent().getStringExtra("genre");
        String imageUrl = getIntent().getStringExtra("image");

        TextView descriptionNameTV = findViewById(R.id.descriptionNameTV);
        TextView descriptionSummaryTV = findViewById(R.id.descriptionSummaryTV);
        TextView descriptionGenreTV = findViewById(R.id.descriptionGenresTV);
        ImageView descriptionImageIV = findViewById(R.id.descriptionImageIV);
        descriptionNameTV.setText(name);
        descriptionSummaryTV.setText(summary);
        descriptionGenreTV.setText(genre);

        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.baseline_downloading_24) // Optional placeholder
                .error(R.drawable.baseline_error_24)           // Optional error fallback
                .into(descriptionImageIV);
    }
}