package com.example.mencobasqlitee.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mencobasqlitee.R;

public class SharedprefManager {

    private static SharedPreferences sharedPreferences;
    private static Context context;

    public SharedprefManager(Context context){
        this.context=context;
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login),
                Context.MODE_PRIVATE);
    }
    public static void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getResources().getString(R.string.login),status);
        editor.commit();


    }
    public boolean loginStatus(){
        boolean status = false;
        status =
                sharedPreferences.getBoolean(context.getResources().getString(R.string.login),
                false);
        return status;
    }
}