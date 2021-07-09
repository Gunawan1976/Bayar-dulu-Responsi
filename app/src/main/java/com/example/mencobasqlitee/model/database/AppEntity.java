package com.example.mencobasqlitee.model.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class AppEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String email;
    private String password;
    private String konpass;

    public AppEntity(String email, String password, String konpass) {
        this.email = email;
        this.password = password;
        this.konpass = konpass;
    }

    public String getKonpass() {
        return konpass;
    }

    public void setKonpass(String konpass) {
        this.konpass = konpass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AppEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", konpass='" + konpass + '\'' +
                '}';
    }
}
