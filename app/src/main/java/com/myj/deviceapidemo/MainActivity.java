package com.myj.deviceapidemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytestapplication.R;
import com.myj.deviceapidemo.manager.DeviceAPIManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(getApplicationContext(), DeviceAPIActivity.class));
    }

    public void startDeviceAPIActivity(View view) {
        startActivity(new Intent(getApplicationContext(), DeviceAPIActivity.class));
    }

    public void startPrinterAPIActivity(View view) {

    }
}