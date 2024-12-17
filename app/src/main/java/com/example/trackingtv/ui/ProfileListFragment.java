package com.example.trackingtv.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trackingtv.R;
import com.example.trackingtv.data.model.CompletedModel;
import com.example.trackingtv.data.model.CompletedRVAdapter;
import com.example.trackingtv.data.model.WatchingModel;
import com.example.trackingtv.data.model.WatchingRVAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;


    private WatchingRVAdapter adapterw;

    private CompletedRVAdapter adapterc;

    private ArrayList<WatchingModel> watchingModels;
    private ArrayList<CompletedModel> completedModels;

    public ProfileListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileListFragment newInstance(String param1, String param2) {
        ProfileListFragment fragment = new ProfileListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile_list, container, false);

        watchingModels = new ArrayList<>();
        completedModels = new ArrayList<>();

//        recyclerView = rootView.findViewById(R.id.RecyclerViewWatching);
//        WatchingRVAdapter adapter = new WatchingRVAdapter(getContext(),watchingModels );
//        recyclerView.setAdapter(adapter);
//        recyclerView = rootView.findViewById(R.id.RecyclerViewCompleted);
//        CompletedRVAdapter adapter1 = new CompletedRVAdapter(getContext(),completedModels );
//        recyclerView.setAdapter(adapter1);

        return rootView;
    }
}