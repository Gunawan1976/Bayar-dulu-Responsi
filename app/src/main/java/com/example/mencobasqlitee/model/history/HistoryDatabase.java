package com.example.mencobasqlitee.model.history;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.mencobasqlitee.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Database(entities = {History.class},version = 1)
public abstract class HistoryDatabase extends RoomDatabase {

    public static HistoryDatabase instance;

    private static Context activity;

    public abstract HIstoryDao hIstoryDao();

    public static synchronized HistoryDatabase getInstance(Context context){

        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    HistoryDatabase.class,"history.db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    private static class PopulateAsyncTask extends AsyncTask<Void,Void,Void>{

        private HIstoryDao hIstoryDao;
        private PopulateAsyncTask(HistoryDatabase database){
            hIstoryDao = database.hIstoryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            hIstoryDao.insert(new History("PLN BILLS","5 July 2021","BCA OneKlik","Success"));
            fillWithStartingData(activity);
            return null;
        }

        private void fillWithStartingData(Context activity) {
            HIstoryDao dao = getInstance(activity).hIstoryDao();
            JSONArray jsonArray = loadJSONArray(activity);

            try {
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String jenispembayaran = jsonObject.getString("jenispembayaran");
                    String tanggal = jsonObject.getString("tanggal");
                    String metodepembayaran = jsonObject.getString("metodepembayaran");
                    String status = jsonObject.getString("status");

                    hIstoryDao.insert(new History(jenispembayaran,tanggal,metodepembayaran,status));

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        private JSONArray loadJSONArray(Context activity) {

            StringBuilder builder = new StringBuilder();
            InputStream inputStream = activity.getResources().openRawResource(R.raw.history);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            try{
                while ((line = reader.readLine())!=null){
                    builder.append(line);
                }
                JSONObject jsonObject = new JSONObject(builder.toString());
                return jsonObject.getJSONArray("data_history");
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
