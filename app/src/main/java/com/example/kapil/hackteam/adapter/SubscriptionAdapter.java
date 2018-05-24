package com.example.kapil.hackteam.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KAPIL on 23-05-2018.
 */

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.SubscriptionViewHolder>  {

    @NonNull
    @Override
    public SubscriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SubscriptionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SubscriptionViewHolder extends RecyclerView.ViewHolder {

        public SubscriptionViewHolder(View itemView) {
            super(itemView);
        }
    }

}
