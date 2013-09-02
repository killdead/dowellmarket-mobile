package com.dowellmarket.android.http;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.http.client.HttpResponseException;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;

import com.dowellmarket.android.model.ApiError;
import com.dowellmarket.android.model.ApiErrors;
import com.dowellmarket.android.model.Settings;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class ApiResponse extends AsyncHttpResponseHandler
{
  public static final Integer[] ERROR_CODES_SERVER;
  public static final int HTTP_UNPROCESSABLE_ENTITY = 422;
  private ApiError firstError;
  private final Context mContext;
  private final OnApiResponseListener mListener;
  private final int mRequestCode;
  private int statusCode = -1;

  static
  {
    Integer[] arrayOfInteger = new Integer[6];
    arrayOfInteger[0] = Integer.valueOf(500);
    arrayOfInteger[1] = Integer.valueOf(501);
    arrayOfInteger[2] = Integer.valueOf(502);
    arrayOfInteger[3] = Integer.valueOf(503);
    arrayOfInteger[4] = Integer.valueOf(504);
    arrayOfInteger[5] = Integer.valueOf(505);
    ERROR_CODES_SERVER = arrayOfInteger;
  }

  public ApiResponse(Context paramContext, int paramInt, OnApiResponseListener paramOnApiResponseListener)
  {
    this.mContext = paramContext;
    this.mListener = paramOnApiResponseListener;
    this.mRequestCode = paramInt;
  }

  private String _getError()
  {
    String str;
    if ((this.statusCode == 0) || (this.statusCode == -1))
      {
    	return str = "error_bad_request";
      }

      if (Arrays.asList(ERROR_CODES_SERVER).contains(Integer.valueOf(this.statusCode)))
      {
        return str = "error_server";
        
      }
      if (this.firstError != null)
      {
        str = this.firstError.getCode();
        if (TextUtils.isEmpty(str))
             Log.e("ApiResponse - Failure - FirstError code", str);
        
        return str;
      }
      switch (this.statusCode)
      {
      
      case 400:
          str = "error_bad_request";
          break;
        case 401:
          str = "error_unauthorized";
          break;
        case 403:
          str = "error_forbidden";
          break;
        case 408:
          str = "error_request_timeout";
          break;
        case 410:
          str = "error_gone"; break;
        case 402:
        case 404:
        case 405:
        case 406:
        case 407:
        case 409:
      default:
        str = "error_bad_request";
        break;
      
      }
      
      return str;
    
  }

  private String _getLocalizedError(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    String str1;
    if (Arrays.asList(ERROR_CODES_SERVER).contains(Integer.valueOf(this.statusCode)))
      str1 = localResources.getString(2131493030);

      if (this.firstError != null)
      {
        str1 = this.firstError.getLocalizedDescription();
        if (!TextUtils.isEmpty(str1))
        {
          Log.e("ApiResponse - Failure - FirstError localized description", str1);
        }
        String str2 = this.firstError.getCode();
        if (!TextUtils.isEmpty(str2))
        {
          if (str2.equals("missing_params"))
          {
            str1 = localResources.getString(2131493029);
          }
          if (str2.equals("user_not_found"))
          {
            str1 = localResources.getString(2131493231);
          }
          if (str2.equals("invalid_password"))
          {
            str1 = localResources.getString(2131493057);
          }
          if (str2.equals("unconfirmed_user"))
          {
            str1 = localResources.getString(2131493226);
          }
          if (str2.equals("sign_in_error"))
          {
            str1 = localResources.getString(2131493201);
          }
          if (str2.equals("age_not_enough"))
          {
            str1 = localResources.getString(2131493021);
          }
          if (str2.equals("license_years_not_enough"))
          {
            str1 = localResources.getString(2131493028);
          }
          if (str2.equals("profile_incomplete"))
          {
            str1 = localResources.getString(2131493033);
          }
          if (str2.equals("birth_date_blank"))
          {
            str1 = localResources.getString(2131493022);
          }
          if (str2.equals("license_release_date_blank"))
          {
            str1 = localResources.getString(2131493027);
          }
          if (str2.equals("facebook_authentication_error"))
          {
            str1 = localResources.getString(2131493029);
          }
          if (str2.equals("invalid_user"))
          {
            str1 = localResources.getString(2131493058);
          }
          if (str2.equals("deleted_user"))
          {
            str1 = localResources.getString(2131493058);
          }
          if (str2.equals("payment_error"))
          {
            str1 = localResources.getString(2131493032);
          }
        }
      }
      switch (this.statusCode)
      {
      default:
        str1 = "Erreur serveur";//localResources.getString(2131493029);
        break;
      case 401:
        Settings.getInstance().setUserApiToken(null);
        str1 = "Erreur serveur";//localResources.getString(2131493034);
        break;
      case 403:
        str1 = "Erreur serveur";
        break;
      case 408:
      case 410:
        str1 = "Erreur serveur";//localResources.getString(2131493094);
      }
      
      return str1;
    
  }

  private boolean _hasErrorsBody(String paramString)
  {
	  boolean bool = false;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("{}")))
    {
    
      try
      {
        bool = new JSONObject(paramString).has("errors");
    
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
      
      return bool;
  }

  private ApiError _parseFirstErrorBody(String paramString)
  {
    return ApiErrors.fromString(paramString).getFirstError();
  }

  public int getRequestCode()
  {
    return this.mRequestCode;
  }

  public int getStatusCode()
  {
    return this.statusCode;
  }

  public void onFailure(Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof HttpResponseException))
    {
      this.statusCode = ((HttpResponseException)paramThrowable).getStatusCode();
      if (!TextUtils.isEmpty(paramString))
    	  Log.e("ApiResponse - Failure - " + this.statusCode, paramString);
      
      Log.e("ApiResponse - Failure", "Status code: " + this.statusCode);
      
      if (!_hasErrorsBody(paramString))
    	  Log.d("ApiResponse - Failure", "No errors in body");
      
//      this.firstError = _parseFirstErrorBody(paramString);
      
      if (this.mListener == null)
    	  Log.e("ApiResponse - Error", "OnApiResponsemListener is not implemented");
      
      this.mListener.onApiRequestFailure(this.mRequestCode, this.statusCode, _getError(), _getLocalizedError(this.mContext));
    }
    else {
	    if ((paramThrowable instanceof UnknownHostException))
	    {
	        this.statusCode = 410;
	    }
	    if ((paramThrowable instanceof ConnectException) || (paramThrowable instanceof SocketTimeoutException))
	    {
	    	  this.statusCode = 408;
	    }
    
	    this.mListener.onApiRequestFailure(this.mRequestCode, this.statusCode, _getError(), _getLocalizedError(this.mContext));
	    
    }
         
  }

  public void onFinish()
  {
    if (this.mListener != null)
      this.mListener.onApiRequestFinish(this.mRequestCode);
    else
      Log.e("ApiResponse - Error", "OnApiResponsemListener is not implemented");
    
  }

  public void onStart()
  {
    if (this.mListener != null)
      this.mListener.onApiRequestStart(this.mRequestCode);
    else
      Log.e("ApiResponse - Error", "OnApiResponsemListener is not implemented");
    
  }

  public void onSuccess(int paramInt, String paramString)
  {
    this.statusCode = paramInt;
    if (TextUtils.isEmpty(paramString))
    {
      Log.i("ApiResponse - Success", "Status code: " + String.valueOf(paramInt));
      if (this.mListener == null)
    	  Log.e("ApiResponse - Error", "OnApiResponsemListener is not implemented");
      if (!_hasErrorsBody(paramString))
    	  this.mListener.onApiRequestSuccess(this.mRequestCode, paramInt, paramString);
      
      this.firstError = _parseFirstErrorBody(paramString);
      this.mListener.onApiRequestFailure(this.mRequestCode, paramInt, _getError(), _getLocalizedError(this.mContext));
    }
    else
    {
      Log.i("ApiResponse - Success 01 - " + paramInt, paramString/*.substring(0, Math.min(paramString.length(), 50)) + " ..."*/);
      if (!_hasErrorsBody(paramString))
    	  this.mListener.onApiRequestSuccess(this.mRequestCode, paramInt, paramString);
   
    }
  }

  public static abstract interface OnApiResponseListener
  {
    public abstract void onApiRequestFailure(int RequestCode, int statusCode, String httpError, String appError);

    public abstract void onApiRequestFinish(int RequestCode);

    public abstract void onApiRequestStart(int RequestCode);

    public abstract void onApiRequestSuccess(int RequestCode, int statusCode, String paramString);
  }
}