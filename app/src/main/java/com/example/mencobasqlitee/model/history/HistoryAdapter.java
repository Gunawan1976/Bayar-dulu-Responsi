package com.example.mencobasqlitee.model.history;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mencobasqlitee.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>implements Filterable {

    private List<History>historyList = new ArrayList<>();

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.jenis.setText(history.getJenispembayaran());
        holder.date.setText(history.getTanggal());
        holder.metode.setText(history.getMetodepembayaran());
        holder.stat.setText(history.getStatus());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }
    public void setHistoryList(List<History>historyList){
        this.historyList = historyList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView jenis;
        private TextView date;
        private TextView metode;
        private TextView stat;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            jenis = itemView.findViewById(R.id.tvJenisPembayaran);
            date = itemView.findViewById(R.id.tvTanggal);
            metode = itemView.findViewById(R.id.tvMetodePembayaran);
            stat = itemView.findViewById(R.id.tvStatus);
        }
    }
}
