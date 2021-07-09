package com.example.mencobasqlitee.model.history;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class History {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String jenispembayaran;
    private String tanggal;
    private String metodepembayaran;
    private String status;

    public History(String jenispembayaran, String tanggal, String metodepembayaran, String status) {
        this.jenispembayaran = jenispembayaran;
        this.tanggal = tanggal;
        this.metodepembayaran = metodepembayaran;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJenispembayaran() {
        return jenispembayaran;
    }

    public void setJenispembayaran(String jenispembayaran) {
        this.jenispembayaran = jenispembayaran;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getMetodepembayaran() {
        return metodepembayaran;
    }

    public void setMetodepembayaran(String metodepembayaran) {
        this.metodepembayaran = metodepembayaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
