package com.myj.deviceapidemo.utils;

import android.content.Context;
import android.os.IBinder;
import android.os.IDeviceApiManager;
import android.util.Log;

import java.lang.reflect.Method;

public class ClassUtils {

    /**
     * 判断是否包含某个方法
     *
     * @param obj        对象
     * @param methodName 方法名称
     * @param argsType   参数类型
     * @return boolean
     */
    public static boolean hasMethod(Object obj, String methodName, Class<?>... argsType) {
        // 从当前类查找
        try {
            Class<?> clazz = obj.getClass();
            clazz.getDeclaredMethod(methodName, argsType);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 从父类中查找
        try {
            Class<?> clazz = obj.getClass();
            clazz.getMethod(methodName, argsType);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
   /* public  static IDeviceApiManager svr;
 public    static void  init_my_IDeviceApiManager(Context context)
    {
        try {
            IBinder binder2 = (IBinder) context.getSystemService("deviceapi");
            if(binder2 ==null)
            {
                Log.e("dd3","error:   binder = (IBinder) context.getSystemService(\"deviceapi\");r); :");
            }
            //iLedService = ILedService.Stub.asInterface(ServiceManager.getService("led"));
            Method getService = Class.forName("android.os.ServiceManager").getMethod("getService", String.class);
            Object ledService = getService.invoke(null, "deviceapi");
            IBinder binder=(IBinder)ledService;
            svr = IDeviceApiManager.Stub.asInterface(binder);
            if(svr ==null)
            {
                Log.e("dd3","error:  svr = IDeviceApiManager.Stub.asInterface(binder); :");
            }


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }*/
    /*
    void init1()
    {

        Class<?> serviceManagerClass = null;
        try {
            serviceManagerClass = Class.forName("android.os.ServiceManager");

            Method getServiceMethod = serviceManagerClass.getDeclaredMethod("getService", String.class);
            IBinder binder = (IBinder) getServiceMethod.invoke(null, "deviceapi");

            //3
            Class<?> serviceStubClass = Class.forName("android.os.ServiceManager");
            Class<?> serviceInterfaceClass = Class.forName("system_service_interface_name");

            Method asInterfaceMethod = serviceInterfaceClass.getDeclaredMethod("asInterface", IBinder.class);
            Object proxy = asInterfaceMethod.invoke(null, binder);


            Method serviceMethod = serviceInterfaceClass.getDeclaredMethod("serviceMethod");
            Object result = serviceMethod.invoke(proxy);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("dd3","   e.printStackTrace(); dddd");
        }



    }*/
}