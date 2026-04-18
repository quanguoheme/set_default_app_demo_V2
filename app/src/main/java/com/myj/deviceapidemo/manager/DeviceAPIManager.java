package com.myj.deviceapidemo.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.DeviceApiManager;
import android.util.Log;
import android.widget.Toast;

import com.myj.deviceapidemo.utils.ClassUtils;

/**
 * 厂商定制设备API管理类
 */
public class DeviceAPIManager {

    private static Context context;
    private static DeviceApiManager deviceApiManager;
    private static final String TAG = DeviceAPIManager.class.getSimpleName();

    /**
     * 初始化API
     *
     * @param c context
     */
    @SuppressLint("WrongConstant")
    public static void initDeviceAPIManager(Context c) {
        context = c;
        deviceApiManager = (DeviceApiManager) context.getSystemService("deviceapi");
        Log.d(TAG, "deviceApiManager=" + deviceApiManager);
    }

    private static void printMessage(String methodName) {
        String message = methodName + "方法不存在";
        Log.d(TAG, message);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取设备序列号（SN码）
     *
     * @return 设备序列号（SN码）
     */
    public static String getSerialNumber() {
        String methodName = "system_getSerialNumber";
        if (ClassUtils.hasMethod(deviceApiManager, methodName)) {
            return deviceApiManager.system_getSerialNumber();
        }
        printMessage(methodName);
        return "";
    }

    /**
     * 显示导航栏
     */
    public static void show_navigation() {
        setNavigationBar(true);
    }

    /**
     * 隐藏导航栏
     */
    public static void hide_navigation() {
        setNavigationBar(false);
    }

    private static void setNavigationBar(boolean enable) {
        String methodName = "system_setNavigationbar";
        if (ClassUtils.hasMethod(deviceApiManager, methodName, boolean.class)) {
            deviceApiManager.system_setNavigationbar(enable);
            return;
        }
        printMessage(methodName);
    }

    /**
     * 静默更新apk
     *
     * @param path apk路径
     */
    public static void install_app(String path) {
        String methodName = "system_installApp";
        if (ClassUtils.hasMethod(deviceApiManager, methodName, String.class)) {
            deviceApiManager.system_installApp(path);
            return;
        }
        printMessage(methodName);
    }

    /**
     * 静默卸载apk
     *
     * @param packageName apk包名
     */
    public static void unInstall_app(String packageName) {
        String methodName = "system_unInstallApp";
        if (ClassUtils.hasMethod(deviceApiManager, methodName, String.class)) {
            deviceApiManager.system_unInstallApp(packageName);
            return;
        }
        printMessage(methodName);
    }




    public static void update_system(String path) {
        String methodName = "system_updateSystem";
        if (ClassUtils.hasMethod(deviceApiManager, methodName, String.class)) {
            deviceApiManager.system_updateSystem(path);
            return;
        }
        printMessage(methodName);
    }

    /**
     * 重启设备
     */
    public static void reboot() {
        String methodName = "system_reboot";
        if (ClassUtils.hasMethod(deviceApiManager, methodName)) {
            new Thread(() -> deviceApiManager.system_reboot()).start();
            return;
        }
        printMessage(methodName);
    }

    /**
     * 增加保活APP
     *
     * @param packageName  APP 包名
     * @param activityName APP 主活动名称
     */
    public static void addAliveApp(String packageName, String activityName) {
        String methodName = "system_aliveApp";
        if (ClassUtils.hasMethod(deviceApiManager, methodName, String.class, String.class)) {
            deviceApiManager.system_aliveApp(packageName, activityName);
            reStartAliveAppServer();
            return;
        }
        printMessage(methodName);
    }

    /**
     * 清空当前已保活的 APP 列表数据，不再保活 APP 时使用该接口。
     */
    public static void clearAliveApp() {
        String methodName = "system_aliveApp_clear";
        if (ClassUtils.hasMethod(deviceApiManager, methodName)) {
            deviceApiManager.system_aliveApp_clear();
            reStartAliveAppServer();
            return;
        }
        printMessage(methodName);
    }

    /**
     * 控制保活服务打开/关闭，操作了保活相关接口操作后，均需要执行该接口重启保活服务才可生效。
     *
     * @param enable true-打开保活服务； false-关闭保活服务
     */
    public static void setAliveAppServer(boolean enable) {
        String methodName = "system_setAliveAppServer";
        if (ClassUtils.hasMethod(deviceApiManager, methodName, boolean.class)) {
            deviceApiManager.system_setAliveAppServer(enable);
            return;
        }
        printMessage(methodName);
    }

    /**
     * 重启保活服务
     */
    public static void reStartAliveAppServer() {
        new Thread(() -> {
            try {
                setAliveAppServer(false);
                Thread.sleep(100);
                setAliveAppServer(true);
                Log.d(TAG, "当前已保活的APP列表：" + getAliveAppList());
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, "重启保活APP服务失败");
            }
        }).start();
    }

    /**
     * 读取当前已保活的 APP 列表。
     *
     * @return 以 String 形式，返回当前已保活的 APP 列表，com.demo/com.demo.MainActivity
     */
    public static String getAliveAppList() {
        String methodName = "system_aliveApp_listPrint";
        if (ClassUtils.hasMethod(deviceApiManager, methodName)) {
            return deviceApiManager.system_aliveApp_listPrint();
        }
        printMessage(methodName);
        return "";
    }

    /**
     * 将当前界面截图，并传入指定路径。
     *
     * @param path 为保存的路径+图片名称+.png；图片格式必须为 png，必须加.png 结尾，支持Environment.getExternalStorageDirectory()获取到的路径
     */
    public static void screenCap(String path) {
        String methodName = "system_screenCap";
        if (ClassUtils.hasMethod(deviceApiManager, methodName, String.class)) {
            deviceApiManager.system_screenCap(path);
            Toast.makeText(context, "图片路径：" + path, Toast.LENGTH_SHORT).show();
            return;
        }
        printMessage(methodName);
    }

    public static void system_run_cmd(String path) {
        String methodName = "system_run_cmd";
        if (ClassUtils.hasMethod(deviceApiManager, methodName, String.class)) {
            deviceApiManager.system_run_cmd(path);
            return;
        }
        printMessage(methodName);
    }


    public static void system_exit_sleep_mode() {
        String methodName = "system_exit_sleep_mode";
        if (ClassUtils.hasMethod(deviceApiManager, methodName)) {
            new Thread(() -> deviceApiManager.system_exit_sleep_mode()).start();
            return;
        }
        printMessage(methodName);
    }

    public static void system_enter_sleep_mode() {
        String methodName = "system_enter_sleep_mode";
        if (ClassUtils.hasMethod(deviceApiManager, methodName)) {
            new Thread(() -> deviceApiManager.system_enter_sleep_mode()).start();
            return;
        }
        printMessage(methodName);
    }
}