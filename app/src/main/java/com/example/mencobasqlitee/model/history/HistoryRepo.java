package com.example.mencobasqlitee.model.history;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class HistoryRepo {

    private HIstoryDao hIstoryDao;
    private LiveData<List<History>>allHistory;

    public HistoryRepo(Application application){
        HistoryDatabase database = HistoryDatabase.getInstance(application);
        hIstoryDao = database.hIstoryDao();
        allHistory = hIstoryDao.getHistory();
    }
    public void insert(History history){
        new InsertHistoryAsyncTask(hIstoryDao).execute(history);
    }
    public void delete(History history){

    }

    public LiveData<List<History>>getAllHistory(){
        return allHistory;
    }

    private class InsertHistoryAsyncTask extends AsyncTask<History,Void,Void> {

        private HIstoryDao hIstoryDao;

        public InsertHistoryAsyncTask(HIstoryDao hIstoryDao) {
            this.hIstoryDao = hIstoryDao;
        }

        @Override
        protected Void doInBackground(History... histories) {
            hIstoryDao.insert(histories[0]);
            return null;
        }
    }
}
