package com.example.mencobasqlitee.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mencobasqlitee.R;
import com.example.mencobasqlitee.databinding.ActivityRecorveryBinding;

public class RecorveryActivity extends AppCompatActivity {

    private ActivityRecorveryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorvery);

        binding = ActivityRecorveryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        assert getSupportActionBar() !=null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}