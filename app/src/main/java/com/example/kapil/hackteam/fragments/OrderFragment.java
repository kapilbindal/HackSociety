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
import com.example.kapil.hackteam.models.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by KAPIL on 26-05-2018.
 */

public class OrderFragment extends Fragment {

    RecyclerView rvOrderList;
    public DatabaseReference mDatabase;
    ArrayList<Order> orderArrayList;
    OrderRecyclerAdapter orderRecyclerAdapter;

    private static final String ARG_SECTION_NUMBER = "section_number";

    public OrderFragment() {
    }

    /*public static OrderFragment newInstance(int sectionNumber) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_passbook, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDatabase = FirebaseDatabase.getInstance().getReference("Orders");
        rvOrderList = view.findViewById(R.id.rvOrderList);
        orderArrayList = new ArrayList<>();
        orderRecyclerAdapter = new OrderRecyclerAdapter(orderArrayList,getContext(),mDatabase);

        rvOrderList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvOrderList.setAdapter(orderRecyclerAdapter);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot taskSnapshot: dataSnapshot.getChildren()){
                    Order order = taskSnapshot.getValue(Order.class);
                    orderArrayList.add(order);
                }
                orderRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}