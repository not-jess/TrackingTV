package com.example.trackingtv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trackingtv.controllers.UserController;


public class RegisterFragment extends Fragment {
    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        UserController userController = new UserController();

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        EditText username = rootView.findViewById(R.id.loginEmailET);
        EditText email = rootView.findViewById(R.id.editTextTextEmail);
        EditText password = rootView.findViewById(R.id.loginPasswordET);
        EditText conpassword = rootView.findViewById(R.id.editTextTextConfirmPassword);

        Button regisBtn = rootView.findViewById(R.id.RegisBtn);
        regisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String ConPassword = conpassword.getText().toString();

                if (!isValid(Username, Email, Password, ConPassword)) {
                    return;
                }

                userController.registerUser(Username, Email, Password, getContext());
            }

        });
        return rootView;
    }

    private boolean isValid(String Username, String Email, String Password, String ConPassword) {
        if (Username.isEmpty() || Email.isEmpty() || Password.isEmpty() || ConPassword.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Password.equals(ConPassword)) {
            Toast.makeText(getContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}