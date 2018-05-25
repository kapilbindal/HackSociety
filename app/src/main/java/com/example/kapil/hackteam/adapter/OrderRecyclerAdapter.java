package com.example.kapil.hackteam.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kapil.hackteam.R;
import com.example.kapil.hackteam.models.Order;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

import static com.example.kapil.hackteam.LoginActivity.TAG;

/**
 * Created by KAPIL on 23-05-2018.
 */

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.OrderViewHolder>  {

    private ArrayList<Order> orderList;
    protected Context context;
    DatabaseReference mDatabase;

    public OrderRecyclerAdapter(ArrayList<Order> orderList, Context context, DatabaseReference mDatabase) {
        this.orderList = orderList;
        this.context = context;
        this.mDatabase = mDatabase;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.payment_cardview,parent,false);
        return new OrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        //Log.e(TAG, "onBindViewHolder: " + orderList.size() + "    " );
        Order currentOrder = orderList.get(position);

        //Log.e(TAG, "onBindViewHolder: " + currentOrder.getPayDetails() + currentOrder.payAmount );
        holder.tvOrderNumber.setText(currentOrder.getOrderNumber() + "");
        holder.tvPayTime.setText(currentOrder.getPayTime() + "");
        holder.tvPayDate.setText(currentOrder.getPayDate() + "");
        holder.tvPayDetails.setText(currentOrder.getPayDetails().toString() + "");
        holder.tvPayAmount.setText("Rs. " + currentOrder.getPayAmount() + "");
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderNumber,tvPayTime,tvPayDate,tvPayDetails,tvPayAmount;
        public OrderViewHolder(View itemView) {
            super(itemView);
            tvOrderNumber = itemView.findViewById(R.id.tvOrderNumber);
            tvPayAmount = itemView.findViewById(R.id.tvPayAmount);
            tvPayDate = itemView.findViewById(R.id.tvPayDate);
            tvPayTime = itemView.findViewById(R.id.tvPayTime);
            tvPayDetails = itemView.findViewById(R.id.tvPayDetails);
        }
    }

}
