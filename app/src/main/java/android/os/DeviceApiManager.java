package android.os;

/**
 * 获取实例对象
 * DeviceApiManager deviceApiManager = (DeviceApiManager) context.getSystemService("deviceapi");
 */
public class DeviceApiManager {

    /**
     * 控制导航栏的显示/隐藏。
     *
     * @param enable true - 控制导航栏和状态栏的显示；false - 控制导航栏和状态栏的隐藏
     */
    public void system_setNavigationbar(boolean enable) {

    }

    /**
     * 静默安装 APK 应用，安装完成之后自启动APP
     *
     * @param path APK 文件所在的路径。支持Environment.getExternalStorageDirectory()获取到的路径
     */
    public void system_installApp(String path) {

    }

    /**
     * 静默卸载 APP
     *
     * @param packageName APP包名
     */
    public void system_unInstallApp(String packageName) {

    }

    /**
     * 升级主板的系统版本，对应的 OTA 升级包由厂家提供。
     *
     * @param path OTA 文件所在的路径。支持Environment.getExternalStorageDirectory()获取到的路径升级包
     */
    public void system_updateSystem(String path) {

    }

    /**
     * 获取设备的SN序列号，作为设备唯一标识，不能更改
     *
     * @return SN序列号
     */
    public String system_getSerialNumber() {
        return "";
    }

    /**
     * 传入需要保活 APP 对应的信息，如 APP 因特殊情况（APP 崩溃、闪退等）停止运行，系统会自动将其重新唤起。
     *
     * @param packageName  传入需保活 APP 的包名
     * @param activityName 传入需保活 APP 的主活动名称
     */
    public void system_aliveApp(String packageName, String activityName) {
    }

    /**
     * 清空当前已保活的 APP 列表数据，不再保活 APP 时使用该接口。
     */
    public void system_aliveApp_clear() {
    }

    /**
     * 控制保活服务打开/关闭，操作了保活相关接口操作后，均需要执行该接口重启保活服务才可生效。
     *
     * @param enable true-打开保活服务； false-关闭保活服务
     */
    public void system_setAliveAppServer(boolean enable) {
    }

    /**
     * 读取当前已保活的 APP 列表。
     *
     * @return 以 String 形式，返回当前已保活的 APP 列表，com.demo/com.demo.MainActivity
     */
    public String system_aliveApp_listPrint() {
        return "";
    }

    /**
     * 控制系统重启。
     */
    public void system_reboot() {
    }

    /**
     * 将当前界面截图，并传入指定路径。
     *
     * @param path 为保存的路径+图片名称+.png；图片格式必须为 png，必须加.png 结尾，支持Environment.getExternalStorageDirectory()获取到的路径
     */
    public void system_screenCap(String path) {
    }

    /**
     * 抓取系统日志
     *
     * @param logFilePath 日志文件路径
     * @param time        抓取时间，以秒为单位，比如：time=10，表示10秒之后结束抓取
     */
    public void system_catchLog(String logFilePath, long time) {
    }


    public void system_enter_sleep_mode()
    {

    }

    public void system_exit_sleep_mode()
    {

    }
    public void system_run_cmd(String cmd)
    {

    }
}