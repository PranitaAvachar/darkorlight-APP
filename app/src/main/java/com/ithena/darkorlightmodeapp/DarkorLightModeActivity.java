package com.ithena.darkorlightmodeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class DarkorLightModeActivity extends AppCompatActivity {

    private Switch switch_btn;
    SaveState saveState;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkor_light_mode);

        saveState = new SaveState(this);
        if (saveState.getstate()==true)
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        switch_btn = findViewById(R.id.switch_btn);
        button=findViewById(R.id.button);

        if (saveState.getstate() == true)
            switch_btn.setChecked(true);

        switch_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    saveState.setstate(true);
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    saveState.setstate(false);
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(DarkorLightModeActivity.this,ImageActivity.class);

                startActivity(in);
            }
        });
    }

}

