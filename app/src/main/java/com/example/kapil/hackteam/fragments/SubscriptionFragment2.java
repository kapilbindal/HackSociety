package com.example.kapil.hackteam.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kapil.hackteam.R;

/**
 * Created by KAPIL on 24-05-2018.
 */

public class SubscriptionFragment2 extends Fragment {
    public SubscriptionFragment2(){

    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.subscription2, container, false);
        return view;
    }
}
