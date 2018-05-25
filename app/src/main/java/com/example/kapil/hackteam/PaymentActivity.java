package com.example.kapil.hackteam;

import android.content.Intent;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.example.kapil.hackteam.adapter.OrderRecyclerAdapter;
import com.example.kapil.hackteam.models.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class PaymentActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {

    private TextView detailsTextView,tvAmount;
    private QRCodeReaderView qrCodeReaderView;
    LinearLayout paymentLayout;
    ArrayList<Order> orderArrayList;
    Button btnPaymentAmount;
    OrderRecyclerAdapter orderRecyclerAdapter;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        detailsTextView = findViewById(R.id.detailsTextView);
        paymentLayout = findViewById(R.id.paymentLayout);
        btnPaymentAmount = findViewById(R.id.btnPayAmount);
        mDatabase = FirebaseDatabase.getInstance().getReference("Orders");
        tvAmount = findViewById(R.id.tvAmount);

        btnPaymentAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mDatabase.push().getKey();
                Toast.makeText(PaymentActivity.this, detailsTextView.getText().toString(), Toast.LENGTH_SHORT).show();
                Order order = new Order(1515544451,11.51,"18 May 2018",detailsTextView.getText().toString(),Integer.parseInt(tvAmount.getText().toString()));
                //orderArrayList.add(order);
                mDatabase.child(id).setValue(order);
            }
        });

        qrCodeReaderView = (QRCodeReaderView) findViewById(R.id.qrdecoderview);
        qrCodeReaderView.setOnQRCodeReadListener(this);

        // Use this function to enable/disable decoding
        qrCodeReaderView.setQRDecodingEnabled(true);

        // Use this function to change the autofocus interval (default is 5 secs)
        qrCodeReaderView.setAutofocusInterval(2000L);

        // Use this function to enable/disable Torch
        qrCodeReaderView.setTorchEnabled(true);

        // Use this function to set front camera preview
        qrCodeReaderView.setFrontCamera();

        // Use this function to set back camera preview
        qrCodeReaderView.setBackCamera();
    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        qrCodeReaderView.setVisibility(View.GONE);
        paymentLayout.setVisibility(View.VISIBLE);
        detailsTextView.setText(text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        qrCodeReaderView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        qrCodeReaderView.stopCamera();
    }
}