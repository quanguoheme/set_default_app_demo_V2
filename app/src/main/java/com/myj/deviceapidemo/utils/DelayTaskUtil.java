package com.myj.deviceapidemo.utils;


import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

public class DelayTaskUtil {
    private static HandlerThread handlerThread;
    private static Handler backgroundHandler;

    // 初始化工作线程
    public static void init() {
        if (handlerThread == null) {
            handlerThread = new HandlerThread("DelayTaskThread");
            handlerThread.start();
            backgroundHandler = new Handler(handlerThread.getLooper());
        }
    }

    // 提交延迟任务
    public static void postDelayed(Runnable task, long delayMillis) {
        if (backgroundHandler == null) {
            throw new IllegalStateException("Must call init() first");
        }
        backgroundHandler.postDelayed(task, delayMillis);
    }
    public static void remove_all_Callbacks() {

        backgroundHandler.removeCallbacksAndMessages(null);
    }
    // 释放资源
    public static void release() {
        if (handlerThread != null) {
            handlerThread.quit();
            handlerThread = null;
            backgroundHandler = null;
        }
    }

    // 示例自定义函数
    public static void demoFunction() {
        Log.d("DelayTask", "执行自定义函数 @" + System.currentTimeMillis());
    }
}
