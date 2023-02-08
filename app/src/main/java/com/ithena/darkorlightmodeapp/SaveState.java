package com.ithena.darkorlightmodeapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SaveState {
    Context context;
    SharedPreferences sharedPreferences;

    public SaveState(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences("preferences",Context.MODE_PRIVATE);
    }

    public void  setstate(boolean bvalue){

        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("bkey",bvalue);
        editor.apply();
    }
    public boolean getstate(){
        return sharedPreferences.getBoolean("bkey",false);
    }
}



