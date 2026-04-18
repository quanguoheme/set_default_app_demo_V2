package com.myj.deviceapidemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytestapplication.R;
import com.myj.deviceapidemo.manager.DeviceAPIManager;
import com.myj.deviceapidemo.manager.PrinterAPIManager;

public class PrinterAPIActivity extends AppCompatActivity {

    private static final String TAG = PrinterAPIActivity.class.getSimpleName();
    private EditText edtTextContent;
    private EditText edtPrintBarCode;
    private EditText edtPrintQrCode;
    private int printerStatus = -100;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_api);
        edtTextContent = findViewById(R.id.edt_textContent);
        edtPrintBarCode = findViewById(R.id.edt_printBarCode);
        edtPrintQrCode = findViewById(R.id.edt_printQrCode);
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int code = intent.getIntExtra("code", -1);
                String message = intent.getStringExtra("message");
                TextView tvPrinterStatus = findViewById(R.id.tv_printerStatus);
                tvPrinterStatus.setText("打印机状态:" + code + " " + message);
                printerStatus = code;
            }
        };
    }

    public void checkPrinterStatus(View view) {
        PrinterAPIManager.checkPrinterStatus(broadcastReceiver);
    }

    public void printText(View view) {
        if (printerStatus != 0) {
            Toast.makeText(getApplicationContext(), "请先检查打印机状态", Toast.LENGTH_SHORT).show();
            return;
        }
        String textContent = edtTextContent.getText().toString();
        if (TextUtils.isEmpty(textContent)) {
            return;
        }
        PrinterAPIManager.printText(textContent);
    }

    public void printPic(View view) {
        if (printerStatus != 0) {
            Toast.makeText(getApplicationContext(), "请先检查打印机状态", Toast.LENGTH_SHORT).show();
            return;
        }
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.change);
        PrinterAPIManager.printPic(bitmap);
    }

    public void printBarCode(View view) {
        if (printerStatus != 0) {
            Toast.makeText(getApplicationContext(), "请先检查打印机状态", Toast.LENGTH_SHORT).show();
            return;
        }
        String printBarCode = edtPrintBarCode.getText().toString();
        if (TextUtils.isEmpty(printBarCode)) {
            return;
        }
        PrinterAPIManager.printBarCode(printBarCode);
    }

    public void printQrCode(View view) {
        if (printerStatus != 0) {
            Toast.makeText(getApplicationContext(), "请先检查打印机状态", Toast.LENGTH_SHORT).show();
            return;
        }
        String printQrCode = edtPrintQrCode.getText().toString();
        if (TextUtils.isEmpty(printQrCode)) {
            return;
        }
        PrinterAPIManager.printQrCode(printQrCode);
    }

    public void endPrint(View view) {
        if (printerStatus != 0) {
            Toast.makeText(getApplicationContext(), "请先检查打印机状态", Toast.LENGTH_SHORT).show();
            return;
        }
        PrinterAPIManager.endPrint();
    }

    public void printSelfTest(View view) {
        if (printerStatus != 0) {
            Toast.makeText(getApplicationContext(), "请先检查打印机状态", Toast.LENGTH_SHORT).show();
            return;
        }
        PrinterAPIManager.printSelfTest();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}