package com.example.trackingtv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import com.example.trackingtv.ui.HomePage;

public class MainActivity extends AppCompatActivity {

    SharedPreferences userPrefData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        userPrefData = getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
        checkLogin();

        Button toLoginBtn = findViewById(R.id.toLoginBtn);
        toLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment, new LoginFragment())
                        .setReorderingAllowed(true)
                        .addToBackStack("login")
                        .commit();

            }
        });


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.flFragment, new LoginFragment())
                .setReorderingAllowed(true)
                .addToBackStack("login")
                .commit();

        Button toRegisterBtn = findViewById(R.id.toRegisterBtn);
        toRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment, new RegisterFragment())
                        .setReorderingAllowed(true)
                        .addToBackStack("register")
                        .commit();
            }
        });
    }

    private void checkLogin() {
        boolean isRemember = userPrefData.getBoolean("user_remember", false);
        if (isRemember) {
            Intent toHome = new Intent(MainActivity.this, HomePage.class);
            startActivity(toHome);
        }
    }
}

