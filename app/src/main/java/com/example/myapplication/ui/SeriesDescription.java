package com.example.myapplication.ui;

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

import com.example.myapplication.R;

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
//        String title = getIntent().getStringExtra("title");
//        int img = getIntent().getIntExtra("img", 0);
//
//        TextView textView = findViewById(R.id.title);
////        textView.setText(title);
//
//        ImageView imageView = findViewById(R.id.thumbnail);
//        if (img != 0) {
//            imageView.setImageResource(img);

//
//        }
    }
}