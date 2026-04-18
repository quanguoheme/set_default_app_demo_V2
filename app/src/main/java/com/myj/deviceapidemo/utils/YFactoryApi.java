package com.myj.deviceapidemo.utils;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class YFactoryApi {


    public static  void root_cmd(String str) {

        execFor7 (str);
    }

    public static  void silentInstallApk() {


    }


    public static boolean execFor7(String command) {
        Log.d("execFor7","command = " + command);
        boolean result = false;
        DataOutputStream dataOutputStream = null;
        BufferedReader errorStream = null;
        try {
            // 申请su权限
            Process process = Runtime.getRuntime().exec("su");
            dataOutputStream = new DataOutputStream(process.getOutputStream());
            // 执行pm install命令
            String s = command + "\n";
            dataOutputStream.write(s.getBytes(Charset.forName("utf-8")));
            dataOutputStream.flush();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            process.waitFor();
            errorStream = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String msg = "";
            String line;
            // 读取命令的执行结果
            while ((line = errorStream.readLine()) != null) {
                msg += line;
            }


            Log.d("execFor7", "execFor7 msg is " + msg);
            // 如果执行结果中包含Failure字样就认为是安装失败，否则就认为安装成功
            if (!msg.contains("Failure")) {
                result = true;
            }
        } catch (Exception e) {
            Log.e("execFor7 err", e.getMessage(), e);
        } finally {
            try {
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (errorStream != null) {
                    errorStream.close();
                }
            } catch (IOException e) {
                Log.e("execFor7 err ", e.getMessage(), e);
            }
        }
        return result;
    }


    public static void copyRawFileToPath(Context context, int rawResId, String destPath) {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            // 获取res/raw目录下的文件输入流
            inputStream = context.getResources().openRawResource(rawResId);
            // 创建目标文件输出流
            File destFile = new File(destPath);
            File parentDir = destFile.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs(); // 如果目标目录不存在，创建目录
            }
            outputStream = new FileOutputStream(destFile);

            // 复制文件内容
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            Log.d("FileCopyUtils", "文件复制成功，目标路径：" + destPath);
        } catch (IOException e) {
            Log.e("FileCopyUtils", "文件复制失败", e);
        } finally {
            // 关闭流
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.flush();

                    outputStream                   .close();
                }
            } catch (IOException e) {
                Log.e("FileCopyUtils", "关闭流失败", e);
            }
        }
    }

}
