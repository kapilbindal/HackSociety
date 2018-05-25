package com.example.kapil.hackteam;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.example.kapil.hackteam.adapter.OrderRecyclerAdapter;
import com.example.kapil.hackteam.models.Order;
import com.example.kapil.hackteam.models.Summary;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class PaymentActivity extends AppCompatActivity implements QRCodeReaderView.OnQRCodeReadListener {

    TextView detailsTextView,tvAddMoneyToWallet;
    EditText edAmount,edBankName,edAddAmount;
    QRCodeReaderView qrCodeReaderView;
    LinearLayout paymentLayout,paymenLayoutQR,addMoneyLayout;
    EditText edSuccess,edAddSuccess;
    Button btnPaymentAmount,btnAddMoney;
    DatabaseReference mDatabase,mDatabaseSummary;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btnAddMoney = findViewById(R.id.btnAddMoney);
        edBankName = findViewById(R.id.edBankName);
        edAddAmount = findViewById(R.id.edAddAmount);
        tvAddMoneyToWallet = findViewById(R.id.tvAddMoneyToWallet);
        detailsTextView = findViewById(R.id.detailsTextView);
        paymentLayout = findViewById(R.id.paymentLayout);
        paymenLayoutQR = findViewById(R.id.paymentLayoutQR);
        addMoneyLayout = findViewById(R.id.addMoneyLayout);
        btnPaymentAmount = findViewById(R.id.btnPayAmount);
        mDatabase = FirebaseDatabase.getInstance().getReference("Orders");
        mDatabaseSummary = FirebaseDatabase.getInstance().getReference("Summary");
        edAmount = findViewById(R.id.edAmount);
        edSuccess = findViewById(R.id.edSuccess);
        edAddSuccess = findViewById(R.id.edAddSuccess);
        progressDialog = new ProgressDialog(this);

        tvAddMoneyToWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymenLayoutQR.setVisibility(View.GONE);
                addMoneyLayout.setVisibility(View.VISIBLE);
            }
        });

        btnAddMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mDatabaseSummary.push().getKey();
                String currentTimeString = DateFormat.getTimeInstance().format(new Date());
                String currentDateString = DateFormat.getDateInstance().format(new Date());
                Summary summary = new Summary("From: " + edBankName.getText(),currentTimeString,currentDateString,Integer.parseInt(edAddAmount.getText().toString())  );
                mDatabaseSummary.child(id).setValue(summary);
                btnAddMoney.setVisibility(View.GONE);

                progressDialog.setMessage("Please wait your money is being Added");
                progressDialog.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hide();
                        edAddSuccess.setVisibility(View.VISIBLE);
                    }
                }, 2000);

                Handler handler3 = new Handler();
                handler3.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(PaymentActivity.this,MainActivity.class));
                    }
                }, 4000);
            }
        });

        btnPaymentAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = mDatabase.push().getKey();
                //Toast.makeText(PaymentActivity.this, detailsTextView.getText().toString(), Toast.LENGTH_SHORT).show();
                String currentTimeString = DateFormat.getTimeInstance().format(new Date());
                String currentDateString = DateFormat.getDateInstance().format(new Date());
                //Summary summary = new Summary("From: " + id,currentTimeString,currentDateString,Integer.parseInt(edAmount.getText().toString())  );
                Order order = new Order(id ,currentTimeString,currentDateString,detailsTextView.getText().toString(),Integer.parseInt(edAmount.getText().toString()));
                mDatabase.child(id).setValue(order);
                //mDatabaseSummary.child(id).setValue(summary);
                btnPaymentAmount.setVisibility(View.GONE);

                progressDialog.setMessage("Please wait your transaction is being processed");
                progressDialog.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.hide();
                        edSuccess.setVisibility(View.VISIBLE);

                    }
                }, 2000);
                Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(PaymentActivity.this,MainActivity.class));
                    }
                }, 4000);
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
        paymenLayoutQR.setVisibility(View.GONE);
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