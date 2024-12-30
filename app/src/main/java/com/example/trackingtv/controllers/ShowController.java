package com.example.trackingtv.controllers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.trackingtv.models.ShowData;
import com.example.trackingtv.models.UserData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowController {
    private DatabaseReference dbRef;

    public ShowController() {
        dbRef = FirebaseDatabase.getInstance().getReference("users");
    }

    public void addToFavorites(String userId, ShowData show, Context context) {
        dbRef.child(userId).child("favorites").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<ShowData> favorites = (ArrayList<ShowData>) task.getResult().getValue();
                if (favorites == null) favorites = new ArrayList<>();
                favorites.add(show);
                dbRef.child(userId).child("favorites").setValue(favorites)
                        .addOnCompleteListener(favTask -> {
                            if (favTask.isSuccessful()) {
                                Toast.makeText(context, "Added to favorites!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Failed to add to favorites.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    public void removeFromFavorites(String userId, int showId, Context context) {
        dbRef.child(userId).child("favorites").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<ShowData> favorites = (ArrayList<ShowData>) task.getResult().getValue();
                if (favorites != null) {
                    favorites.removeIf(show -> show.getId() == showId);
                    dbRef.child(userId).child("favorites").setValue(favorites)
                            .addOnCompleteListener(favTask -> {
                                if (favTask.isSuccessful()) {
                                    Toast.makeText(context, "Removed from favorites!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "Failed to remove from favorites.", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
    }

    public void addToWatchlist(String userId, ShowData show, Context context) {
        dbRef.child(userId).child("watchlist").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<ShowData> watchlist = (ArrayList<ShowData>) task.getResult().getValue();
                if (watchlist == null) watchlist = new ArrayList<>();
                watchlist.add(show);
                dbRef.child(userId).child("watchlist").setValue(watchlist)
                        .addOnCompleteListener(watchlistTask -> {
                            if (watchlistTask.isSuccessful()) {
                                Toast.makeText(context, "Added to watchlist!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Failed to add to watchlist.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    public void removeFromWatchlist(String userId, int showId, Context context) {
        dbRef.child(userId).child("watchlist").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<ShowData> watchlist = (ArrayList<ShowData>) task.getResult().getValue();
                if (watchlist != null) {
                    watchlist.removeIf(show -> show.getId() == showId);
                    dbRef.child(userId).child("watchlist").setValue(watchlist)
                            .addOnCompleteListener(watchlistTask -> {
                                if (watchlistTask.isSuccessful()) {
                                    Toast.makeText(context, "Removed from watchlist!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(context, "Failed to remove from watchlist.", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
    }

    public void logCompletedShow(String userId, ShowData show, Context context) {
        dbRef.child(userId).child("completed").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ArrayList<ShowData> completed = (ArrayList<ShowData>) task.getResult().getValue();
                if (completed == null) completed = new ArrayList<>();
                completed.add(show);
                dbRef.child(userId).child("completed").setValue(completed)
                        .addOnCompleteListener(compTask -> {
                            if (compTask.isSuccessful()) {
                                Toast.makeText(context, "Show logged as completed!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Failed to log show.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    public void trackProgress(String userId, int showId, int episodesWatched, Context context) {
        dbRef.child(userId).child("progress").child(String.valueOf(showId)).setValue(episodesWatched)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(context, "Progress updated!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Failed to update progress.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void getUserData(String userId, Context context, UserDataCallback callback) {
        dbRef.child(userId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                UserData userData = task.getResult().getValue(UserData.class);
                callback.onSuccess(userData);
            } else {
                Toast.makeText(context, "Failed to get user data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public interface UserDataCallback {
        void onSuccess(UserData userData);
    }

    public void getFavorites(String userId, ShowListCallback callback) {
        dbRef.child(userId).child("favorites").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<ShowData> favorites = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    ShowData show = data.getValue(ShowData.class);
                    if (show != null) favorites.add(show);
                }
                callback.onSuccess(favorites);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onFailure(error.getMessage());
            }
        });
    }

    public void getWatchlist(String userId, ShowListCallback callback) {
        dbRef.child(userId).child("watchlist").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<ShowData> watchlist = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    ShowData show = data.getValue(ShowData.class);
                    if (show != null) watchlist.add(show);
                }
                callback.onSuccess(watchlist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onFailure(error.getMessage());
            }
        });
    }

    public void getCompleted(String userId, ShowListCallback callback) {
        dbRef.child(userId).child("completed").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<ShowData> completed = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    ShowData show = data.getValue(ShowData.class);
                    if (show != null) completed.add(show);
                }
                callback.onSuccess(completed);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onFailure(error.getMessage());
            }
        });
    }

    public void getWatching(String userId, ShowListCallback callback) {
        dbRef.child(userId).child("progress").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<ShowData> watching = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {
                    int showId = Integer.parseInt(data.getKey());
                    int episodesWatched = data.getValue(Integer.class);

                    // Here, assume we fetch the full `ShowData` from an external source like the TVMaze API.
                    // Simulating fetching with dummy data for now:
                    ShowData show = new ShowData(showId, "Dummy Name", "Dummy Summary",
                            new ArrayList<>(), "DummyImageUrl", 100, "DummyTVMazeUrl");
                    if (episodesWatched > 0) {
                        watching.add(show);
                    }
                }
                callback.onSuccess(watching);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                callback.onFailure(error.getMessage());
            }
        });
    }

    public interface ShowListCallback {
        void onSuccess(ArrayList<ShowData> showList);

        void onFailure(String errorMessage);
    }
}
