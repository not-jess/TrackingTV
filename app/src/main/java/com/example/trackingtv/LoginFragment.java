package com.example.trackingtv;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trackingtv.controllers.UserController;
import com.example.trackingtv.models.UserData;
import com.example.trackingtv.ui.HomePage;



public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    SharedPreferences userPrefData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UserController userController = new UserController();
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        EditText emailET = rootView.findViewById(R.id.loginEmailET);
        EditText passwordET = rootView.findViewById(R.id.loginPasswordET);
        CheckBox rememberCB = rootView.findViewById(R.id.loginRememberCB);

        userPrefData = getActivity().getSharedPreferences("user_preferences", Context.MODE_PRIVATE);

        Button submitBtn = rootView.findViewById(R.id.loginSubmitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
                boolean isRemember = rememberCB.isChecked();

                if (isRemember) {
                    SharedPreferences.Editor editor = userPrefData.edit();
                    editor.putString("user_email", email);
                    editor.putString("user_password", password);
                    editor.putBoolean("user_remember", isRemember);
                    editor.apply();
                }

                if (!isValid(email, password)) {
                    return;
                }
                userController.loginUser(email, password, getContext(), new UserController.LoginCallback() {
                    @Override
                    public void onSuccess(UserData userData) {
                        Toast.makeText(getContext(), "Welcome, " + userData.getName(), Toast.LENGTH_SHORT).show();
                        Intent toHome = new Intent(getActivity(), HomePage.class);
                        startActivity(toHome);
                        // Handle successful login and retrieved user data
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        // Handle login failure
                        Toast.makeText(getContext(), "Login failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        return rootView;
    }

    private boolean isValid(String Email, String Password) {
        if(Email.isEmpty() || Password.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}