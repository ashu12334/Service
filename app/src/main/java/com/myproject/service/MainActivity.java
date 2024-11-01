package com.myproject.service;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   TextView txt;
   public static final String Tag = "MainActivity";
   Button strt_btn, stop_btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt = findViewById(R.id.txt1);
        strt_btn = findViewById(R.id.start_btn);
        stop_btn = findViewById(R.id.stop_btn);
        strt_btn.setOnClickListener(this);
        stop_btn.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Intent serviceIntent = new Intent(getApplicationContext(), MyCustomService.class);
        if(v.getId() == R.id.start_btn){
            startService(serviceIntent);
            Log.d(Tag,"Service Started");
            txt.setText("Service Started");
        } else if(v.getId() == R.id.stop_btn){
            stopService(serviceIntent);
            Log.d(Tag,"Service Stopped");
            txt.setText("Service Stopped");
        }
    }
}