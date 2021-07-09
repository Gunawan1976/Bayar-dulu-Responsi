package com.example.mencobasqlitee.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mencobasqlitee.R;
import com.example.mencobasqlitee.model.Cupang;

import java.util.ArrayList;

public class CupangAdapter extends RecyclerView.Adapter<CupangAdapter.ViewHolder>{

    private final ArrayList<Cupang> listcupang;
    private OnitemClickCallback onitemClickCallback;

    public CupangAdapter(ArrayList<Cupang> listcupang) {
        this.listcupang = listcupang;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cupang cupang = listcupang.get(position);
        Glide.with(holder.itemView.getContext())
                .load(cupang.getImage())
                .apply(new RequestOptions())
                .into(holder.imageView);
        holder.nama.setText(cupang.getNama());

        final Context context = holder.itemView.getContext();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemClickCallback.onItemClicked(listcupang.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listcupang.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.iv_cupang);
            nama = itemView.findViewById(R.id.tv_cupang);
        }
    }

    private interface OnitemClickCallback {

        void onItemClicked(Cupang data);
    }
}
