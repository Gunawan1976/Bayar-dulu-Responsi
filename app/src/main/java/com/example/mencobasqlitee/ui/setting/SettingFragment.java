package com.example.mencobasqlitee.ui.setting;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mencobasqlitee.ui.ProfileActivity;
import com.example.mencobasqlitee.R;
import com.example.mencobasqlitee.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {

    private SettingViewModel settingFragment;
    private ImageView profile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        settingFragment = new ViewModelProvider(this).get(SettingViewModel.class);
        View root =  inflater.inflate(R.layout.fragment_setting,container,false);
         profile = root.findViewById(R.id.iv_infoprofile);

         profile.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getActivity(),ProfileActivity.class));
             }
         });

        return root;
    }
}