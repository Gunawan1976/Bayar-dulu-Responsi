package com.example.mencobasqlitee.model.history;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface HIstoryDao {

    @Insert
    void insert(History history);

    @Delete
    void delete(History history);

    @Query("SELECT * FROM history ORDER BY jenispembayaran ASC")
    LiveData<List<History>> getHistory();
}
