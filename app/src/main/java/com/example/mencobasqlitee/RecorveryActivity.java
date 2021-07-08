package com.example.mencobasqlitee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RecorveryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorvery);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}