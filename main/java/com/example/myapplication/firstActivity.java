package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class firstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstactivity);

        SystemClock.sleep(3000);
        Intent loginintent = new Intent(firstActivity.this,register_activity.class);
        startActivity(loginintent);
        finish();

    }

}