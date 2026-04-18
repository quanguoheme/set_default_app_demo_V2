package android.os;

import android.graphics.Bitmap;

/**
 * 获取实例对象
 * PrinterApiManager printerApiManager = (PrinterApiManager)context.getSystemService("printerApi");
 */
public class PrinterApiManager {

    public static String PRINTER_STATUS_ACTION = "android.os.PrinterApiManager.PrinterStatus";

    /**
     * 检查打印机状态
     * 0：状态正常；-1：接收数据失败；-2：打印机缺纸；-3：打印机纸将尽；-4：打印机开盖；-5：发送数据失败；-6：未知打印机状态
     * 状态通过广播返回：
     * Intent intent = new Intent(PrinterApiManager.PRINTER_STATUS_ACTION);
     * intent.putExtra("code", 0);
     * intent.putExtra("message", "状态正常");
     * sendBroadcast(intent);
     */
    public void checkPrinterStatus() {

    }

    /**
     * 打印文本
     */
    public void printText(String content) {

    }

    /**
     * 打印图片
     */
    public void printPic(Bitmap bitmap) {

    }

    /**
     * 打印条形码
     */
    public void printBarCode(String barCode) {

    }

    /**
     * 打印二维码
     */
    public void printQrCode(String qrCode) {

    }

    /**
     * 结束打印
     */
    public void endPrint() {

    }

    /**
     * 打印自检页
     */
    public void printSelfTest() {

    }
}