package com.example.kapil.hackteam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kapil.hackteam.R;
import com.example.kapil.hackteam.models.Summary;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by KAPIL on 23-05-2018.
 */

public class SummaryRecyclerAdapter extends RecyclerView.Adapter<SummaryRecyclerAdapter.SummaryViewHolder>  {

    private ArrayList<Summary> summaryList;
    protected Context context;
    DatabaseReference mDatabase;


    public SummaryRecyclerAdapter(ArrayList<Summary> summaryList, Context context, DatabaseReference mDatabase) {
        this.summaryList = summaryList;
        this.context = context;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public SummaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.added_money_cardview,parent,false);
        return new SummaryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SummaryViewHolder holder, int position) {
        Summary currentSummary = summaryList.get(position);

        holder.tvAddedFrom.setText(currentSummary.getAddedFrom() + "");
        holder.tvAddTime.setText(currentSummary.getAddTime() + "");
        holder.tvAddDate.setText(currentSummary.getAddDate() + "");
        holder.tvAddAmount.setText("Rs. " + currentSummary.getAddAmount() + "");
    }

    @Override
    public int getItemCount() {
        return summaryList.size();
    }

    class SummaryViewHolder extends RecyclerView.ViewHolder {
        TextView tvAddedFrom, tvAddTime, tvAddDate, tvAddAmount;
        public SummaryViewHolder(View itemView) {
            super(itemView);
            tvAddedFrom = itemView.findViewById(R.id.tvAddedFrom);
            tvAddAmount = itemView.findViewById(R.id.tvAddAmount);
            tvAddDate = itemView.findViewById(R.id.tvAddDate);
            tvAddTime = itemView.findViewById(R.id.tvAddTime);
        }
    }

}
