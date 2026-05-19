package com.myj.deviceapidemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BootStartReceiver extends BroadcastReceiver {
    private static final String TAG = "dd3";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            return;
        }
        if (!App.isOpenBootEnabled()) {
            Log.d(TAG, "Boot start is disabled");
            return;
        }
        else{
            Log.d(TAG, "Boot start is enabled");
        }
        Intent launchIntent = new Intent(context, MainActivity.class);
        launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(launchIntent);
    }
}
