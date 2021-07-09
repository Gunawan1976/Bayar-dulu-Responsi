package com.example.mencobasqlitee.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mencobasqlitee.R;
import com.example.mencobasqlitee.bottom_nav;
import com.example.mencobasqlitee.databinding.ActivityRegisterBinding;
import com.example.mencobasqlitee.model.database.AppDao;
import com.example.mencobasqlitee.model.database.AppDatabase;
import com.example.mencobasqlitee.model.database.AppEntity;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private AppDao appDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDao = Room.databaseBuilder(this, AppDatabase.class,"database.db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();

        binding.btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.etEmail.getText().toString().trim();
                String pass = binding.etPassword.getText().toString().trim();
                String konPass = binding.etConfPass.getText().toString().trim();

                if (pass.equals(konPass)){
                    AppEntity appEntity = new AppEntity(email,pass,konPass);
                    appDao.insert(appEntity);
                    Intent moveToHome = new Intent(RegisterActivity.this, bottom_nav.class);
                    startActivity(moveToHome);
                }else{
                    Toast.makeText(RegisterActivity.this," password tidak sesuai",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}