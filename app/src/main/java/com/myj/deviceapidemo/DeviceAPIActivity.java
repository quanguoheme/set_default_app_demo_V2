package com.myj.deviceapidemo;

import static java.lang.Thread.sleep;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytestapplication.R;
import com.myj.deviceapidemo.manager.DeviceAPIManager;
import com.myj.deviceapidemo.utils.DelayTaskUtil;
import com.myj.deviceapidemo.utils.YFactoryApi;

import java.io.File;

public class DeviceAPIActivity extends AppCompatActivity {
    private EditText  edt_default_app;
    private EditText edtAppPackageName;
    private EditText edtPackageName;
    private EditText edtAppActivityName;
    private TextView tvAliveApp;
    public static String TAG="batt2";
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_api);
        edt_default_app = findViewById(R.id.edt_default_app);
        edtAppPackageName = findViewById(R.id.edt_appPackageName);
        edtPackageName = findViewById(R.id.edt_packageName);
        edtAppActivityName = findViewById(R.id.edt_appActivityName);
        tvAliveApp = findViewById(R.id.tv_AliveApp);
        context=this.getApplicationContext();
       // ClassUtils.init_my_IDeviceApiManager(this.getApplicationContext());
        reg_Receiver_for_BatteryCharging(this);
        DelayTaskUtil.init();
    }

    public void getSerialNumber(View view) {
        String serialNumber = DeviceAPIManager.getSerialNumber();
        Log.d(TAG,"serialNumber 1 :"+serialNumber);
        try {
          //  serialNumber =  ClassUtils.svr.system_getSerialNumber();
            Log.d(TAG,"serialNumber 2 :"+serialNumber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        TextView tvSerialNumber = findViewById(R.id.tv_SerialNumber);
        tvSerialNumber.setText("序列号1:" + serialNumber);
    }

    public void app_go_to_exception(View view) {
        if(1>0)
        {

            int i=1;
            int b=0;
            int c=i/b;
            Log.d("","c:"+c);
        }

    }



    public void install_app(View view) {
        String fil_path=  ("/sdcard" + "/test.apk");
        File fil= new File(fil_path);
        String cmd= "pm install -i com.android.server -r "+fil_path;
        if(!fil.exists())
        {
            String path_inter=context.getFilesDir()+"dd.apk" ;

            YFactoryApi.copyRawFileToPath(this,R.raw.term,path_inter);
            YFactoryApi.execFor7("cp "+path_inter +" "+fil_path );
        }

        if(!fil.exists())
        {
            Log.d(TAG,"install_app fail nofile exist  ");
            return;
        }

        Log.d(TAG,"install_app "+cmd);
        YFactoryApi.execFor7(cmd);
       // DeviceAPIManager.install_app(Environment.getExternalStorageDirectory() + "/test.apk");
    }

    public void unInstall_app(View view) {
        String appPackageName = edtAppPackageName.getText().toString();
        if (TextUtils.isEmpty(appPackageName)) {
            return;
        }
        String cmd= "pm uninstall "+ appPackageName;
        Log.d(TAG,"unInstall_app "+cmd);
        YFactoryApi.execFor7(cmd);

       /* String appPackageName = edtAppPackageName.getText().toString();
        if (TextUtils.isEmpty(appPackageName)) {
            return;
        }
        DeviceAPIManager.unInstall_app(appPackageName);*/
    }
    public void hide_navigation(View view) {
        Log.d(TAG," DeviceAPIManager.hide_navigation(); ");
        DeviceAPIManager.hide_navigation();

    }

    public void show_navigation(View view) {
        Log.d(TAG," DeviceAPIManager.show_navigation(); ");
        DeviceAPIManager.show_navigation();

    }

    public void set_default_app_name(View view) {

        edtAppPackageName.setText("com.example.normal.mytestapplication");
        edt_default_app.setText("com.example.normal.mytestapplication");
        String packageName = edtPackageName.getText().toString();
        if (TextUtils.isEmpty(packageName))
        {
            packageName="com.example.normal.mytestapplication";
            edtPackageName.setText(packageName);
        }
        String appActivityName = edtAppActivityName.getText().toString();
        if (TextUtils.isEmpty(appActivityName))
        {
            appActivityName="com.myj.deviceapidemo.MainActivity";
            edtAppActivityName.setText(appActivityName);
        }
    }
    public void clear_default_app_name(View view) {
        Log.d(TAG,"clear_default_app_name ");
        set_default_app_proc("clr");
    }
    public void set_default_app(View view) {
        Log.d(TAG,"set_default_app");
        String appPackageName = edt_default_app.getText().toString();
        if (TextUtils.isEmpty(appPackageName)) {
            return;
        }
         set_default_app_proc(appPackageName);
    }

    private void set_default_app_proc(String appPackageName) {
        String cmd="setprop persist.defaultgc.homeapp "+appPackageName;
        Log.d(TAG,"__set_default_app : "+cmd);
        YFactoryApi.execFor7(cmd);
    }

    public void reboot(View view) {
        ///DeviceAPIManager.reboot();
        String cmd="reboot " ;
        Log.d(TAG,"reboot with DeviceAPIManager  : "+cmd);
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               show_reboot_Dialog();
           }
       });


    }

    public void addAliveApp(View view) {
        String packageName = edtPackageName.getText().toString();
        if (TextUtils.isEmpty(packageName))
        {
            return;
        }
        String appActivityName = edtAppActivityName.getText().toString();
        if (TextUtils.isEmpty(appActivityName))
        {
            return;
        }
        DeviceAPIManager.addAliveApp(packageName, appActivityName);
        String aliveAppList = DeviceAPIManager.getAliveAppList();
        tvAliveApp.setText("current keep live APP list：" + aliveAppList);
    }

    public void clearAliveApp(View view) {
        DeviceAPIManager.clearAliveApp();
        String aliveAppList = DeviceAPIManager.getAliveAppList();
        tvAliveApp.setText("current keep live APP list：" + aliveAppList);
    }

    public void screenCap(View view) {
        String path = Environment.getExternalStorageDirectory() + "/" + System.currentTimeMillis() + ".png";
        DeviceAPIManager.screenCap(path);
    }

    public void show_reboot_Dialog() {
        Toast.makeText(context, " DeviceAPIManager.reboot(); ", Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(5555);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                DeviceAPIManager.reboot();
            }
        }).start();



    }

    public     BatteryReceiver   mBatteryReceiver2=new BatteryReceiver();
    public   class BatteryReceiver extends BroadcastReceiver {
        public static final String TAG = "batt2";
        public boolean enable=false;
        public boolean is_sleep_status =false;
        @Override
        public void onReceive(Context context, Intent intent) {
            // 获取广播事件
            String action = intent.getAction();

            if(!TextUtils.equals("android.intent.action.BATTERY_CHANGED", action)){
                return;
            }

            Log.d(TAG, "  jason2 :  554335level:"+
                    ", intent.getAction():"+ intent.getAction());
            Log.d(TAG, " jason2  " + intent.getIntExtra("level", -1));
            Log.d(TAG, " jason2  " + intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -2));
            final int levde=intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -2);
            //BatteryManager.BATTERY_STATUS_CHARGING 表示是充电状态
            // BatteryManager.BATTERY_STATUS_DISCHARGING 放电中
            // BatteryManager.BATTERY_STATUS_NOT_CHARGING 未充电
            // BatteryManager.BATTERY_STATUS_FULL 电池满
            if(BatteryManager.BATTERY_STATUS_CHARGING  == intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN))
            {
                if(is_sleep_status)
                {
                    DelayTaskUtil.remove_all_Callbacks();
                    Log.d(TAG, " jason2 ,  enable is_sleep_status2  begin postDelayed "  +is_sleep_status);
                    DelayTaskUtil.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            is_sleep_status =false;
                            DeviceAPIManager.system_exit_sleep_mode();
                            Log.d(TAG, " jason2 ,  enable is_sleep_status2  run  postDelayed "  +is_sleep_status);
                        }
                    }, 10); // 3000毫秒=3秒
                }
                // 发送延迟3秒的消息

                Log.d(TAG, " jason2  BATTERY_STATUS_CHARGING " + intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(levde ==100)
                        {
                            Log.d(TAG, "BATTERY_STATUS_is full 充电满 :"+levde);
                        }
                        else
                            Log.d(TAG, "BATTERY_STATUS_CHARGING 充电中 :"+levde);
                    }
                });
            }
            else
            {
                Log.d(TAG, " jason2 ,battery is not at charging, " + intent.getIntExtra("status", BatteryManager.BATTERY_STATUS_UNKNOWN));
                if(enable)
                {

                    if(!is_sleep_status)
                    {
                        Log.d(TAG, " jason2 ,  enable is_sleep_status2     begin_enter_sleep "  );
                        DelayTaskUtil.remove_all_Callbacks();
                        DelayTaskUtil.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Log.d(TAG, " jason2 ,  enable is_sleep_status2  end_enter_sleep  "  );
                                DeviceAPIManager.system_enter_sleep_mode();
                                is_sleep_status =true;
                            }
                        }, 10_000); // 3000毫秒=3秒


                    }

                  //  DeviceAPIManager. system_run_cmd("input keyevent KEYCODE_POWER \n");

                }
                else {
                    Log.d(TAG, " jason2 ,   not enable sleep mode "  );

                }

            }



        }
    }

    public   void unReg_Receiver_for_BatteryCharging(Context context){
        context.unregisterReceiver(mBatteryReceiver2);
    }

    /**
     * 主动获取当前电池是否在充电 , 即数据线是否插在手机上
     * @return
     */
    public   void reg_Receiver_for_BatteryCharging(Context context){
        boolean isBatteryCharging = false;

        // 主动发送包含是否正在充电状态的广播 , 该广播会持续发送
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        // 注册广播接受者
        Intent intent = context.registerReceiver(mBatteryReceiver2, intentFilter);


    }

    public void btn_begin_sleep_test(View view) {
        mBatteryReceiver2.enable=true;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Toast toast = Toast.makeText(context,
                        "The device open sleep mode 1 system_exit_sleep_mode   .  system_enter_sleep_mode(); ",
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });



       //DeviceAPIManager. system_run_cmd("input keyevent KEYCODE_POWER \n");
       // DeviceAPIManager.  system_enter_sleep_mode();
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
               while (isRun)
               {
                   try {
                       sleep(1000);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   DeviceAPIManager. system_exit_sleep_mode();
                   try {
                       sleep(2200);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
            }
        }).start();
            */
    }
   volatile boolean isRun=true;
    @Override
    protected void onDestroy() {
        super.onDestroy();
        isRun=false;
    }
}