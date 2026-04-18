/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package android.os;
/**
 * @hide
 */
public interface IDeviceApiManager extends android.os.IInterface
{
  /** Default implementation for IDeviceApiManager. */
  public static class Default implements android.os.IDeviceApiManager
  {
    @Override public void system_setNavigationbar(boolean enable) throws android.os.RemoteException
    {
    }
    @Override public void system_installApp(java.lang.String path) throws android.os.RemoteException
    {
    }
    @Override public void system_updateSystem(java.lang.String path) throws android.os.RemoteException
    {
    }
    @Override public java.lang.String system_getSerialNumber() throws android.os.RemoteException
    {
      return null;
    }
    @Override public void system_aliveApp(java.lang.String packageName, java.lang.String activityName) throws android.os.RemoteException
    {
    }
    @Override public void system_aliveApp_clear() throws android.os.RemoteException
    {
    }
    @Override public void system_setAliveAppServer(boolean enable) throws android.os.RemoteException
    {
    }
    @Override public java.lang.String system_aliveApp_listPrint() throws android.os.RemoteException
    {
      return null;
    }
    @Override public void system_reboot() throws android.os.RemoteException
    {
    }
    @Override public void system_screenCap(java.lang.String path) throws android.os.RemoteException
    {
    }
    @Override public void system_unInstallApp(java.lang.String packageName) throws android.os.RemoteException
    {
    }
    @Override public void system_catchLog(java.lang.String logFilePath, long time) throws android.os.RemoteException
    {
    }
    @Override public void system_playAudio(java.lang.String text) throws android.os.RemoteException
    {
    }
    @Override public void systemReady() throws android.os.RemoteException
    {
    }
    @Override public void system_enter_sleep_mode() throws android.os.RemoteException
    {
    }
    @Override public void system_exit_sleep_mode() throws android.os.RemoteException
    {
    }
    @Override public void system_run_cmd(java.lang.String cmd) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements android.os.IDeviceApiManager
  {
    private static final java.lang.String DESCRIPTOR = "android.os.IDeviceApiManager";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an android.os.IDeviceApiManager interface,
     * generating a proxy if needed.
     */
    public static android.os.IDeviceApiManager asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof android.os.IDeviceApiManager))) {
        return ((android.os.IDeviceApiManager)iin);
      }
      return new android.os.IDeviceApiManager.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    /** @hide */
    public static java.lang.String getDefaultTransactionName(int transactionCode)
    {
      switch (transactionCode)
      {
        case TRANSACTION_system_setNavigationbar:
        {
          return "system_setNavigationbar";
        }
        case TRANSACTION_system_installApp:
        {
          return "system_installApp";
        }
        case TRANSACTION_system_updateSystem:
        {
          return "system_updateSystem";
        }
        case TRANSACTION_system_getSerialNumber:
        {
          return "system_getSerialNumber";
        }
        case TRANSACTION_system_aliveApp:
        {
          return "system_aliveApp";
        }
        case TRANSACTION_system_aliveApp_clear:
        {
          return "system_aliveApp_clear";
        }
        case TRANSACTION_system_setAliveAppServer:
        {
          return "system_setAliveAppServer";
        }
        case TRANSACTION_system_aliveApp_listPrint:
        {
          return "system_aliveApp_listPrint";
        }
        case TRANSACTION_system_reboot:
        {
          return "system_reboot";
        }
        case TRANSACTION_system_screenCap:
        {
          return "system_screenCap";
        }
        case TRANSACTION_system_unInstallApp:
        {
          return "system_unInstallApp";
        }
        case TRANSACTION_system_catchLog:
        {
          return "system_catchLog";
        }
        case TRANSACTION_system_playAudio:
        {
          return "system_playAudio";
        }
        case TRANSACTION_systemReady:
        {
          return "systemReady";
        }
        case TRANSACTION_system_enter_sleep_mode:
        {
          return "system_enter_sleep_mode";
        }
        case TRANSACTION_system_exit_sleep_mode:
        {
          return "system_exit_sleep_mode";
        }
        case TRANSACTION_system_run_cmd:
        {
          return "system_run_cmd";
        }
        default:
        {
          return null;
        }
      }
    }
    /** @hide */
    public java.lang.String getTransactionName(int transactionCode)
    {
      return this.getDefaultTransactionName(transactionCode);
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_system_setNavigationbar:
        {
          data.enforceInterface(descriptor);
          boolean _arg0;
          _arg0 = (0!=data.readInt());
          this.system_setNavigationbar(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_installApp:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.system_installApp(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_updateSystem:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.system_updateSystem(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_getSerialNumber:
        {
          data.enforceInterface(descriptor);
          java.lang.String _result = this.system_getSerialNumber();
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_system_aliveApp:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          java.lang.String _arg1;
          _arg1 = data.readString();
          this.system_aliveApp(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_aliveApp_clear:
        {
          data.enforceInterface(descriptor);
          this.system_aliveApp_clear();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_setAliveAppServer:
        {
          data.enforceInterface(descriptor);
          boolean _arg0;
          _arg0 = (0!=data.readInt());
          this.system_setAliveAppServer(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_aliveApp_listPrint:
        {
          data.enforceInterface(descriptor);
          java.lang.String _result = this.system_aliveApp_listPrint();
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_system_reboot:
        {
          data.enforceInterface(descriptor);
          this.system_reboot();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_screenCap:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.system_screenCap(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_unInstallApp:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.system_unInstallApp(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_catchLog:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          long _arg1;
          _arg1 = data.readLong();
          this.system_catchLog(_arg0, _arg1);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_playAudio:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.system_playAudio(_arg0);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_systemReady:
        {
          data.enforceInterface(descriptor);
          this.systemReady();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_enter_sleep_mode:
        {
          data.enforceInterface(descriptor);
          this.system_enter_sleep_mode();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_exit_sleep_mode:
        {
          data.enforceInterface(descriptor);
          this.system_exit_sleep_mode();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_system_run_cmd:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.system_run_cmd(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements android.os.IDeviceApiManager
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      @Override public void system_setNavigationbar(boolean enable) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(((enable)?(1):(0)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_setNavigationbar, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_setNavigationbar(enable);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_installApp(java.lang.String path) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(path);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_installApp, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_installApp(path);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_updateSystem(java.lang.String path) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(path);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_updateSystem, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_updateSystem(path);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public java.lang.String system_getSerialNumber() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_getSerialNumber, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().system_getSerialNumber();
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void system_aliveApp(java.lang.String packageName, java.lang.String activityName) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(packageName);
          _data.writeString(activityName);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_aliveApp, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_aliveApp(packageName, activityName);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_aliveApp_clear() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_aliveApp_clear, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_aliveApp_clear();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_setAliveAppServer(boolean enable) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(((enable)?(1):(0)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_setAliveAppServer, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_setAliveAppServer(enable);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public java.lang.String system_aliveApp_listPrint() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_aliveApp_listPrint, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().system_aliveApp_listPrint();
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void system_reboot() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_reboot, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_reboot();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_screenCap(java.lang.String path) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(path);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_screenCap, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_screenCap(path);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_unInstallApp(java.lang.String packageName) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(packageName);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_unInstallApp, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_unInstallApp(packageName);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_catchLog(java.lang.String logFilePath, long time) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(logFilePath);
          _data.writeLong(time);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_catchLog, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_catchLog(logFilePath, time);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_playAudio(java.lang.String text) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(text);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_playAudio, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_playAudio(text);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void systemReady() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_systemReady, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().systemReady();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_enter_sleep_mode() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_enter_sleep_mode, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_enter_sleep_mode();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_exit_sleep_mode() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_exit_sleep_mode, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_exit_sleep_mode();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void system_run_cmd(java.lang.String cmd) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(cmd);
          boolean _status = mRemote.transact(Stub.TRANSACTION_system_run_cmd, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().system_run_cmd(cmd);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static android.os.IDeviceApiManager sDefaultImpl;
    }
    static final int TRANSACTION_system_setNavigationbar = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_system_installApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_system_updateSystem = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_system_getSerialNumber = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_system_aliveApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_system_aliveApp_clear = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    static final int TRANSACTION_system_setAliveAppServer = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
    static final int TRANSACTION_system_aliveApp_listPrint = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
    static final int TRANSACTION_system_reboot = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
    static final int TRANSACTION_system_screenCap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
    static final int TRANSACTION_system_unInstallApp = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
    static final int TRANSACTION_system_catchLog = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
    static final int TRANSACTION_system_playAudio = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
    static final int TRANSACTION_systemReady = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
    static final int TRANSACTION_system_enter_sleep_mode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 14);
    static final int TRANSACTION_system_exit_sleep_mode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 15);
    static final int TRANSACTION_system_run_cmd = (android.os.IBinder.FIRST_CALL_TRANSACTION + 16);
    public static boolean setDefaultImpl(android.os.IDeviceApiManager impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static android.os.IDeviceApiManager getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void system_setNavigationbar(boolean enable) throws android.os.RemoteException;
  public void system_installApp(java.lang.String path) throws android.os.RemoteException;
  public void system_updateSystem(java.lang.String path) throws android.os.RemoteException;
  public java.lang.String system_getSerialNumber() throws android.os.RemoteException;
  public void system_aliveApp(java.lang.String packageName, java.lang.String activityName) throws android.os.RemoteException;
  public void system_aliveApp_clear() throws android.os.RemoteException;
  public void system_setAliveAppServer(boolean enable) throws android.os.RemoteException;
  public java.lang.String system_aliveApp_listPrint() throws android.os.RemoteException;
  public void system_reboot() throws android.os.RemoteException;
  public void system_screenCap(java.lang.String path) throws android.os.RemoteException;
  public void system_unInstallApp(java.lang.String packageName) throws android.os.RemoteException;
  public void system_catchLog(java.lang.String logFilePath, long time) throws android.os.RemoteException;
  public void system_playAudio(java.lang.String text) throws android.os.RemoteException;
  public void systemReady() throws android.os.RemoteException;
  public void system_enter_sleep_mode() throws android.os.RemoteException;
  public void system_exit_sleep_mode() throws android.os.RemoteException;
  public void system_run_cmd(java.lang.String cmd) throws android.os.RemoteException;
}
