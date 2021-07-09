package com.example.mencobasqlitee.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mencobasqlitee.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}