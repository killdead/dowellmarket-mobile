package com.dowellmarket.android.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Build;


public class Application extends android.app.Application
{
  public static final int GOOGLE_PLAY_ERROR_DIALOG_REQUEST_CODE = 200;
  private static int GooglePlayServiceResultCode;
  private static Context mContext;
  private static LocationManager mLocationManager;
/*
  private void _setAnalytics()
  {
    EasyTracker.getInstance().setContext(mContext);
    ExceptionReporter localExceptionReporter = new ExceptionReporter(EasyTracker.getTracker(), GAServiceManager.getInstance(), Thread.getDefaultUncaughtExceptionHandler());
    if ((localExceptionReporter instanceof ExceptionReporter))
      ((ExceptionReporter)localExceptionReporter).setExceptionParser(new AnalyticsExceptionParser());
  }*/

  public static Context getContext()
  {
    return mContext;
  }

  /*public static Dialog googlePlayServiceErrorDialog(Activity paramActivity)
  {
    return GooglePlayServicesUtil.getErrorDialog(GooglePlayServiceResultCode, paramActivity, 200);
  }*/

  public static boolean hasFeatureCamera()
  {
    return mContext.getPackageManager().hasSystemFeature("android.hardware.camera");
  }

  public static boolean hasFeatureTelephony()
  {
    return mContext.getPackageManager().hasSystemFeature("android.hardware.telephony");
  }

  public static boolean isGPSLocationEnabled()
  {
    return mLocationManager.isProviderEnabled("gps");
  }

  @SuppressLint({"NewApi"})
  public static boolean isGeocoderPresent()
  {
	  boolean bool = false;
    if (Build.VERSION.SDK_INT > 8);
      {
    	  bool = Geocoder.isPresent(); 
      }
      return bool;
  }

  public static boolean isGooglePlayServiceAvailable()
  {
    if (GooglePlayServiceResultCode == 0);
      return true;
  }

  public static boolean isLocationEnabled()
  {
    if ((isGPSLocationEnabled()) || (isNetworkLocationEnabled()));
     return true;
  }

  public static boolean isNetworkLocationEnabled()
  {
    return mLocationManager.isProviderEnabled("network");
  }

  public void onCreate()
  {
    super.onCreate();
    mContext = getApplicationContext();
    mLocationManager = (LocationManager)getSystemService("location");
  }
}
