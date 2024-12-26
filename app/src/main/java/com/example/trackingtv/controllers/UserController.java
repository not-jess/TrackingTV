package com.example.trackingtv.controllers;

import android.content.Context;
import android.widget.Toast;

import com.example.trackingtv.models.UserData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserController {

    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;

    public UserController() {
        mAuth = FirebaseAuth.getInstance();
        dbRef = FirebaseDatabase.getInstance().getReference("users");
    }
    public void registerUser(String name, String email, String password, Context context) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()) {
                        String uid = mAuth.getCurrentUser().getUid();

                        UserData user = new UserData(uid, name, email, password);

                        dbRef.child(uid).setValue(user).addOnCompleteListener(dbTask -> {
                            if (dbTask.isSuccessful()) {
                                Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Failed to register user", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(context, "Auth error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void loginUser(String email, String password, Context context) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()) {
                        Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Auth error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
