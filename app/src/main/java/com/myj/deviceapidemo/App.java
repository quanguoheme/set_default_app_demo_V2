package com.myj.deviceapidemo;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.myj.deviceapidemo.manager.DeviceAPIManager;
import com.myj.deviceapidemo.manager.PrinterAPIManager;

public class App extends Application {

    private static final String PREFS_NAME = "device_api_demo_prefs";
    private static final String KEY_OPEN_BOOT_FLAG = "open_boot_flag";
    private static Context context;
    private static boolean open_boot_flag=false;

    public static Context getContext() {
        return context;
    }

    public static boolean isOpenBootEnabled() {
        return open_boot_flag;
    }

    public static void setOpenBootEnabled(boolean enabled) {
        open_boot_flag = enabled;
        if (context == null) {
            return;
        }
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        prefs.edit().putBoolean(KEY_OPEN_BOOT_FLAG, enabled).apply();

    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        open_boot_flag = prefs.getBoolean(KEY_OPEN_BOOT_FLAG, false);

        DeviceAPIManager.initDeviceAPIManager(this);
    }
}
