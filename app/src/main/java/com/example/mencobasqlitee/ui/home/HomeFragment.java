package com.example.mencobasqlitee.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mencobasqlitee.R;
import com.example.mencobasqlitee.databinding.FragmentHomeBinding;
import com.example.mencobasqlitee.model.Cupang;
import com.example.mencobasqlitee.model.adapter.CupangAdapter;
import com.example.mencobasqlitee.model.data.CupangData;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ArrayList<Cupang>list = new ArrayList<>();

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        binding.recycleview.setHasFixedSize(true);

        list.addAll(CupangData.getData());
        showRecycleList();

        return root;
    }

    private void showRecycleList() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        binding.recycleview.setLayoutManager(layoutManager);
        CupangAdapter cupangAdapter = new CupangAdapter(list);
        binding.recycleview.setAdapter(cupangAdapter);

    }
}