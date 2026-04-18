package com.myj.deviceapidemo.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.PrinterApiManager;
import android.util.Log;
import android.widget.Toast;

import com.myj.deviceapidemo.utils.ClassUtils;

/**
 * 厂商定制打印API管理类
 */
public class PrinterAPIManager {

    private static Context context;
    private static PrinterApiManager printerApiManager;
    private static final String TAG = PrinterApiManager.class.getSimpleName();

    /**
     * 初始化API
     *
     * @param c context
     */
    @SuppressLint("WrongConstant")
    public static void initPrinterApiManager(Context c) {
        context = c;
        printerApiManager = (PrinterApiManager) context.getSystemService("printerApi");
        Log.d(TAG, "printerApiManager=" + printerApiManager);
    }

    private static void printMessage(String methodName) {
        String message = methodName + "方法不存在";
        Log.d(TAG, message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 检查打印机状态，结果通过广播返回，
     *
     * @param broadcastReceiver 监听打印机状态广播
     */
    public static void checkPrinterStatus(BroadcastReceiver broadcastReceiver) {
        String methodName = "checkPrinterStatus";
        if (ClassUtils.hasMethod(printerApiManager, methodName)) {
            printerApiManager.checkPrinterStatus();
            context.registerReceiver(broadcastReceiver, new IntentFilter(PrinterApiManager.PRINTER_STATUS_ACTION));
            return;
        }
        printMessage(methodName);
    }

    /**
     * 打印文本
     */
    public static void printText(String content) {
        String methodName = "printText";
        if (ClassUtils.hasMethod(printerApiManager, methodName, String.class)) {
            printerApiManager.printText(content);
            return;
        }
        printMessage(methodName);
    }

    /**
     * 打印图片
     */
    public static void printPic(Bitmap bitmap) {
        String methodName = "printPic";
        if (ClassUtils.hasMethod(printerApiManager, methodName, Bitmap.class)) {
            printerApiManager.printPic(bitmap);
            return;
        }
        printMessage(methodName);
    }

    /**
     * 打印条形码
     */
    public static void printBarCode(String barCode) {
        String methodName = "printBarCode";
        if (ClassUtils.hasMethod(printerApiManager, methodName, String.class)) {
            printerApiManager.printBarCode(barCode);
            return;
        }
        printMessage(methodName);
    }

    /**
     * 打印二维码
     */
    public static void printQrCode(String qrCode) {
        String methodName = "printQrCode";
        if (ClassUtils.hasMethod(printerApiManager, methodName, String.class)) {
            printerApiManager.printQrCode(qrCode);
            return;
        }
        printMessage(methodName);
    }

    /**
     * 结束打印，如果有切刀功能，则切刀，需要走纸就走纸，要保证拿到的小票内容完整
     */
    public static void endPrint() {
        String methodName = "endPrint";
        if (ClassUtils.hasMethod(printerApiManager, methodName)) {
            printerApiManager.endPrint();
            return;
        }
        printMessage(methodName);
    }

    /**
     * 打印自检页
     */
    public static void printSelfTest() {
        String methodName = "printSelfTest";
        if (ClassUtils.hasMethod(printerApiManager, methodName)) {
            printerApiManager.printSelfTest();
            return;
        }
        printMessage(methodName);
    }
}