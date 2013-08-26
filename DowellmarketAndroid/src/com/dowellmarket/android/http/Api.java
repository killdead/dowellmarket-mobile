package com.dowellmarket.android.http;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.dowellmarket.android.model.Filters;
import com.dowellmarket.android.model.Settings;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import java.io.UnsupportedEncodingException;
import org.apache.http.entity.StringEntity;

public class Api
{
  private static final String BASE_URL = "http://192.168.0.12/elgg";
  private static final String METHOD_GET = "GET";
  private static final String METHOD_POST = "POST";
  private static final String METHOD_PUT = "PUT";
  private static final String PATH_CARS = "cars";
  private static final String PATH_DEVICE = "devices";
  private static final String PATH_PICTURES_UPLOAD_SETTINGS = "pictures/upload_settings";
  private static final String PATH_PROFILE = "profile";
  private static final String PATH_PROFILE_AUTH_TOKEN = "profile/auth_token";
  private static final String PATH_REGISTRATIONS = "registrations";
  private static final String PATH_SEARCH = "search";
  private static final String PATH_SESSIONS = "sessions";
  private static final String PATH_USERS = "users";
  public static final int REQUEST_CODE_CAR_AVAILABILITY = 6;
  public static final int REQUEST_CODE_CAR_BOOKING_AUTHORIZATION = 7;
  public static final int REQUEST_CODE_CAR_GET = 5;
  public static final int REQUEST_CODE_CAR_NEW = 14;
  public static final int REQUEST_CODE_CAR_PRE_BOOK = 9;
  public static final int REQUEST_CODE_CAR_REQUEST = 8;
  public static final int REQUEST_CODE_DEVICE = 15;
  public static final int REQUEST_CODE_PICTURES_UPLOAD_SETTINGS = 1;
  public static final int REQUEST_CODE_PROFILE_AUTH_TOKEN = 13;
  public static final int REQUEST_CODE_SEARCH = 10;
  public static final int REQUEST_CODE_USER_PROFILE_GET = 2;
  public static final int REQUEST_CODE_USER_PROFILE_PUT = 3;
  public static final int REQUEST_CODE_USER_REVIEWS = 4;
  public static final int REQUEST_CODE_USER_SIGN_IN = 11;
  public static final int REQUEST_CODE_USER_SIGN_UP = 12;
  private static final String SUB_PATH_AVAILABILITY = "availability";
  private static final String SUB_PATH_BOOKING_AUTHORIZATION = "booking_authorization";
  private static final String SUB_PATH_PRE_BOOK = "pre_book";
  private static final String SUB_PATH_REQUEST = "request";
  private static final String SUB_PATH_REVIEWS = "reviews";
  private static AsyncHttpClient client = new AsyncHttpClient();
  private ApiResponse mApiResponse;
  private final Context mContext;
  private final ApiResponse.OnApiResponseListener mListener;

  public Api(Context paramContext, ApiResponse.OnApiResponseListener paramOnApiResponseListener)
  {
    this.mContext = paramContext;
    this.mListener = paramOnApiResponseListener;
  }

  private static void _get(Context paramContext, String paramString, RequestParams paramRequestParams, ApiResponse paramApiResponse)
  {
    String str = _getAbsoluteUrl(paramString);
    _setHeaders();
    _setStartMessage(str, "GET");
    client.get(paramContext, str, paramRequestParams, paramApiResponse);
  }

  private static String _getAbsoluteUrl(String paramString)
  {
    return BASE_URL + paramString;
  }

  private static void _post(Context paramContext, String paramString1, String paramString2, ApiResponse paramApiResponse)
  {
    String str = _getAbsoluteUrl(paramString1);
    _setHeaders();
    _setStartMessage(str, "POST");
    try
    {
      client.post(paramContext, str, new StringEntity(paramString2, "UTF-8"), "application/json", paramApiResponse);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
  }

  private static void _put(Context paramContext, String paramString1, String paramString2, ApiResponse paramApiResponse)
  {
    String str = _getAbsoluteUrl(paramString1);
    _setHeaders();
    _setStartMessage(str, "PUT");
    try
    {
      client.put(paramContext, str, new StringEntity(paramString2, "UTF-8"), "application/json", paramApiResponse);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
  }

  private static void _setHeaders()
  {
    client.addHeader("HTTP_X_VL_AUTHORIZATION", "cf4d2f5591763483bf1f258c5820e411");
    client.addHeader("Accept-Charset", "UTF-8");
    Settings localSettings = Settings.getInstance();
    if ((localSettings != null) && (localSettings.hasApiToken()))
    {
      String str = localSettings.getUserApiToken();
      if (!TextUtils.isEmpty(str))
        client.addHeader("Authorization", "Token token=\"" + str + "\"");
    }
  }

  private static void _setStartMessage(String paramString1, String paramString2)
  {
    Log.i("ApiRequest - Start", "Method: " + paramString2 + ", URL: " + paramString1);
  }

  private ApiResponse newApiResponse(int paramInt)
  {
    return new ApiResponse(this.mContext, paramInt, this.mListener);
  }

  public void getCar(Long paramLong)
  {
    String str = "cars/" + paramLong.toString();
    this.mApiResponse = newApiResponse(5);
    _get(this.mContext, str, null, this.mApiResponse);
  }

  public void getCarAvailability(Long paramLong)
  {
    String str = "cars/" + paramLong.toString() + "/" + "availability" + Filters.getInstance().toUrl();
    this.mApiResponse = newApiResponse(6);
    _get(this.mContext, str, null, this.mApiResponse);
  }

  public void getCarBookingAuthorization(Long paramLong)
  {
    String str = "cars/" + paramLong.toString() + "/" + "booking_authorization";
    this.mApiResponse = newApiResponse(7);
    _get(this.mContext, str, null, this.mApiResponse);
  }

  public int getLoadingMessageRes()
  {
    int i;
    switch (this.mApiResponse.getRequestCode())
    {
    case 6:
    case 7:
    case 8:
    case 9:
    default:
      i = 2131493163; break;
    case 2: i = 2131493168;break;
    case 4:  i = 2131493177;break;
    case 5:  i = 2131492922;break;
    case 10:  i = 2131492940;break;
    case 11:  i = 2131493202;break;
    case 12: i = 2131493205;break;
    case 3:  i = 2131493186;break;
    }
  return i;
  }

  public void getPicturesUploadSettings()
  {
    this.mApiResponse = newApiResponse(1);
    _get(this.mContext, "pictures/upload_settings", null, this.mApiResponse);
  }

  public void getProfile()
  {
    this.mApiResponse = newApiResponse(2);
    _get(this.mContext, "profile", null, this.mApiResponse);
  }

  public void getProfileAuthToken()
  {
    this.mApiResponse = newApiResponse(13);
    _get(this.mContext, "profile/auth_token", null, this.mApiResponse);
  }

  public void getSearch()
  {
    String str = "search/" + Filters.getInstance().toUrl();
    this.mApiResponse = newApiResponse(10);
    _get(this.mContext, str, null, this.mApiResponse);
  }

  public void getUserReviews(Integer paramInteger)
  {
    String str = "users/" + paramInteger.toString() + "/" + "reviews";
    this.mApiResponse = newApiResponse(4);
    _get(this.mContext, str, null, this.mApiResponse);
  }

  public void interruptRequests()
  {
    client.cancelRequests(this.mContext, true);
  }

  /*public void postCarNew(CarNew paramCarNew)
  {
    String str = "{\"car\":" + paramCarNew.toString() + "}";
    this.mApiResponse = newApiResponse(14);
    _post(this.mContext, "cars", str, this.mApiResponse);
  }

  public void postCarPreBook(Long paramLong, Payment paramPayment)
  {
    String str = "cars/" + paramLong.toString() + "/" + "pre_book";
    this.mApiResponse = newApiResponse(9);
    _post(this.mContext, str, paramPayment.toString(), this.mApiResponse);
  }

  public void postCarRequest(Long paramLong, String paramString)
  {
    String str = "cars/" + paramLong.toString() + "/" + "request";
    this.mApiResponse = newApiResponse(8);
    _post(this.mContext, str, paramString, this.mApiResponse);
  }

  public void postDevice(String paramString)
  {
    String str = "{\"device\": {\"token\":\"" + paramString + "\"}}";
    this.mApiResponse = newApiResponse(15);
    _post(this.mContext, "devices", str, this.mApiResponse);
  }

  public void postRegistration(User paramUser)
  {
    String str = "{\"user\":" + paramUser.toString() + "}";
    this.mApiResponse = newApiResponse(12);
    _post(this.mContext, "registrations", str, this.mApiResponse);
  }

  public void postSession(User paramUser)
  {
    this.mApiResponse = newApiResponse(11);
    _post(this.mContext, "sessions", paramUser.toString(), this.mApiResponse);
  }

  public void putProfile(User paramUser)
  {
    String str = "{\"user\":" + paramUser.toString() + "}";
    this.mApiResponse = newApiResponse(3);
    _put(this.mContext, "profile", str, this.mApiResponse);
  }*/
}
