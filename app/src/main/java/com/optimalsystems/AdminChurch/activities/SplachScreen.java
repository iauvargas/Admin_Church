package com.optimalsystems.AdminChurch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.optimalsystems.AdminChurch.R;

public class SplachScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splachscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplachScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }
}