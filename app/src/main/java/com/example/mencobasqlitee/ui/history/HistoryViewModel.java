package com.example.mencobasqlitee.ui.history;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mencobasqlitee.model.history.History;
import com.example.mencobasqlitee.model.history.HistoryRepo;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
    private HistoryRepo historyRepo;
    private LiveData<List<History>>allHistory;

    public HistoryViewModel(Application application) {
        super(application);
        historyRepo = new HistoryRepo(application);
        allHistory = historyRepo.getAllHistory();
    }
    public void insert(History history){
        historyRepo.insert(history);
    }
    public LiveData<List<History>>getAllHistory(){
        return allHistory;
    }
}