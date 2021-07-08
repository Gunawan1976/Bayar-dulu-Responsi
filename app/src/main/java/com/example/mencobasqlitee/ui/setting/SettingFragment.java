package com.example.mencobasqlitee.ui.setting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mencobasqlitee.R;

public class SettingFragment extends Fragment {

    private SettingViewModel settingFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        settingFragment = new ViewModelProvider(this).get(SettingViewModel.class);
        View root =  inflater.inflate(R.layout.fragment_setting,container,false);

        return root;
    }
}