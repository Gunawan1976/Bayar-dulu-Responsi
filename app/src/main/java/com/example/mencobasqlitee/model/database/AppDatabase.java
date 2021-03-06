package com.example.mencobasqlitee.model.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AppEntity.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao getUserDao();
}
