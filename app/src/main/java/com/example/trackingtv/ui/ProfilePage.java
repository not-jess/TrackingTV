package com.example.trackingtv.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import com.example.trackingtv.MainActivity;
import com.example.trackingtv.R;

public class ProfilePage extends AppCompatActivity {

    SharedPreferences userPrefData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_page);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;


        });

        userPrefData = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

        TextView logoutTV = findViewById(R.id.profileLogoutTV);
        logoutTV.setOnClickListener(v -> {
            userPrefData.edit().clear().apply();

            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        Button toOverviewBtn = findViewById(R.id.overviewbtn);
        toOverviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment, new OverviewFragment())
                        .setReorderingAllowed(true)
                        .addToBackStack("Overview")
                        .commit();
            }
        });

        Button toListButton = findViewById(R.id.listbtn);
        toListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment, new ListFragment())
                        .setReorderingAllowed(true)
                        .addToBackStack("List")
                        .commit();
            }
        });
    }
}