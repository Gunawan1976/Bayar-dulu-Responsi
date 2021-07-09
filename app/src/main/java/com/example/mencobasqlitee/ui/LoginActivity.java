package com.example.mencobasqlitee.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mencobasqlitee.R;
import com.example.mencobasqlitee.bottom_nav;
import com.example.mencobasqlitee.databinding.ActivityMainBinding;
import com.example.mencobasqlitee.model.database.AppDao;
import com.example.mencobasqlitee.model.database.AppDatabase;
import com.example.mencobasqlitee.model.database.AppEntity;

public class LoginActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    AppDao db;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = Room.databaseBuilder(this,AppDatabase.class,"database.db")
                .allowMainThreadQueries()
                .build();

        db = database.getUserDao();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvForgotPass.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, RecorveryActivity.class);
            startActivity(i);
        });
        binding.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent r = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(r);
            }
        });

        binding.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = binding.etEmailProfile.getText().toString().trim();
                String pass = binding.etPass.getText().toString().trim();
                AppEntity appEntity = db.getUser(email,pass);

                if (appEntity !=null){
                    Intent i = new Intent(LoginActivity.this, bottom_nav.class);
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this,"Belum terdaftar atau kosong",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}