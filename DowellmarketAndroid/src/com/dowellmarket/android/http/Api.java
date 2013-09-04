package com.dowellmarket.android.http;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.dowellmarket.android.model.Filters;
import com.dowellmarket.android.model.Settings;
import com.dowellmarket.android.model.User;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

public class Api
{
  private static final String BASE_URL = "http://10.89.4.155/elgg/services/api/rest/json?";
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
  public static final int REQUEST_CODE_PICTURES_UPLOAD_SETTINGS = 11;
  public static final int REQUEST_CODE_PROFILE_AUTH_TOKEN = 13;
  public static final int REQUEST_CODE_SEARCH = 10;
  public static final int REQUEST_CODE_USER_PROFILE_GET = 2;
  public static final int REQUEST_CODE_USER_PROFILE_PUT = 3;
  public static final int REQUEST_CODE_USER_REVIEWS = 4;
  public static final int REQUEST_CODE_USER_SIGN_IN = 1;
  public static final int REQUEST_CODE_USER_SIGN_UP = 12;
  private static final String SUB_PATH_AVAILABILITY = "availability";
  private static final String SUB_PATH_BOOKING_AUTHORIZATION = "booking_authorization";
  private static final String SUB_PATH_PRE_BOOK = "pre_book";
  private static final String SUB_PATH_REQUEST = "request";
  private static final String SUB_PATH_REVIEWS = "reviews";
  private static AsyncHttpClient client = new AsyncHttpClient();
  private ApiResponse mApiResponse;
  private static String USER_AUTH_TOKEN;
  private final Context mContext;
  private final ApiResponse.OnApiResponseListener mListener;

  public Api(Context paramContext, ApiResponse.OnApiResponseListener paramOnApiResponseListener)
  {
    this.mContext = paramContext;
    this.mListener = paramOnApiResponseListener;
  }

  private static void _get(Context paramContext, RequestParams mRequestParams, ApiResponse paramApiResponse)
  {
    String str = _getAbsoluteUrl();
    _setHeaders();
    _setStartMessage(str, "GET");
    
    if(USER_AUTH_TOKEN != "")
    {
    	mRequestParams.put("auth_token", USER_AUTH_TOKEN);
    }
    
    
    client.get(paramContext, str, mRequestParams, paramApiResponse);
  }

  private static String _getAbsoluteUrl()
  {
    return BASE_URL;
  }


  private static void _put(Context paramContext, String paramString2, ApiResponse paramApiResponse)
  {
    String str = _getAbsoluteUrl();
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
    //client.addHeader("HTTP_X_VL_AUTHORIZATION", "cf4d2f5591763483bf1f258c5820e411");
    client.addHeader("Accept-Charset", "UTF-8");
    
    Settings localSettings = Settings.getInstance();
   
  }

  private static void _setStartMessage(String paramString1, String paramString2)
  {
    Log.i("ApiRequest - Start", "Method: " + paramString2 + ", URL: " + paramString1);
  }

  private ApiResponse newApiResponse(int paramInt)
  {
    return new ApiResponse(this.mContext, paramInt, this.mListener);
  }
  
  public String getBaseUrl() {
  return BASE_URL;
  }
  
  
  
  private static void _post(Context paramContext,RequestParams mRequestParams, ApiResponse paramApiResponse) {
		 
	    _setHeaders();
	    _setStartMessage(BASE_URL, "POST");
	    
	    if(USER_AUTH_TOKEN != "")
	    {
	    	mRequestParams.put("auth_token", USER_AUTH_TOKEN);
	    }
	    
	    try
	    {
	      client.post(paramContext, BASE_URL,mRequestParams, paramApiResponse);
	      return;
	    }
	    catch (Exception localUnsupportedEncodingException)
	    {
	     
	        localUnsupportedEncodingException.printStackTrace();
	    }
	
}

public String getUserAuthToken() {
	return USER_AUTH_TOKEN;
}

public void setUserAuthToken(String auth_token) {
	USER_AUTH_TOKEN = auth_token;
}
  
  
  
  public void postSession(User paramUser)
  {
    this.mApiResponse = newApiResponse(REQUEST_CODE_USER_SIGN_IN);
   
    _post(this.mContext, paramUser.getLoginRequestParams(), this.mApiResponse);
  }
  
  
  
  
  public void getSearch()
  {
  //  String str = "category/" + Filters.getInstance().toUrl();
    
    RequestParams rp = Filters.getInstance().getRequestParam();
    
    this.mApiResponse = newApiResponse(10);
    _get(this.mContext, rp, this.mApiResponse);
  }
  
/*

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

 

  public void interruptRequests()
  {
    client.cancelRequests(this.mContext, true);
  }

  public void postCarNew(CarNew paramCarNew)
  {
    String str = "{\"car\":" + paramCarNew.toString() + "}";
    this.mApiResponse = newApiResponse(14);
    _post(this.mContext, "cars", str, this.mApiResponse);
  }

  
  public void postRegistration(User paramUser)
  {
    String str = "{\"user\":" + paramUser.toString() + "}";
    this.mApiResponse = newApiResponse(12);
    _post(this.mContext, "registrations", str, this.mApiResponse);
  }
  */




}
