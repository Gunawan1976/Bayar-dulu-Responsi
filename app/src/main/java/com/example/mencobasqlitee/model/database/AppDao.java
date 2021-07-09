package com.example.mencobasqlitee.model.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AppDao {
    @Query("SELECT * FROM AppEntity where email= :email and password= :password")
    AppEntity getUser(String email, String password);

    @Insert
    void insert(AppEntity appDao);


}
