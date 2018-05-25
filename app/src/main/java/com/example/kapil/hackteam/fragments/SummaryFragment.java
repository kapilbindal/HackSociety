package com.example.kapil.hackteam.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kapil.hackteam.R;
import com.example.kapil.hackteam.adapter.OrderRecyclerAdapter;
import com.example.kapil.hackteam.adapter.SummaryRecyclerAdapter;
import com.example.kapil.hackteam.models.Order;
import com.example.kapil.hackteam.models.Summary;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.zip.ZipEntry;

/**
 * Created by KAPIL on 26-05-2018.
 */

public class SummaryFragment extends Fragment {

    RecyclerView rvSummaryList;
    public DatabaseReference mDatabase;
    ArrayList<Summary> summaryArrayList;
    SummaryRecyclerAdapter summaryRecyclerAdapter;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public SummaryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_summary, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference("Summary");
        rvSummaryList = view.findViewById(R.id.rvSummaryList);
        summaryArrayList = new ArrayList<>();
        summaryRecyclerAdapter = new SummaryRecyclerAdapter(summaryArrayList,getContext(),mDatabase);

        rvSummaryList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSummaryList.setAdapter(summaryRecyclerAdapter);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot taskSnapshot: dataSnapshot.getChildren()){
                    Summary summary = taskSnapshot.getValue(Summary.class);
                    summaryArrayList.add(summary);
                }
                summaryRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}