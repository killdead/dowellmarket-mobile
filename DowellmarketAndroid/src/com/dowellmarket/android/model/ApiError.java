package com.dowellmarket.android.model;

import android.text.TextUtils;

public class ApiError extends Model
{
  public static final String AGE_NOT_ENOUGH = "age_not_enough";
  public static final String BAD_REQUEST = "error_bad_request";
  public static final String BIRTH_DATE_BLANK = "birth_date_blank";
  public static final String DELETED_USER = "deleted_user";
  public static final String FACEBOOK_AUTH = "facebook_authentication_error";
  public static final String FORBIDDEN = "error_forbidden";
  public static final String INVALID_PASSWORD = "invalid_password";
  public static final String INVALID_USER = "invalid_user";
  public static final String LICENSE_RELEASE_DATE_BLANK = "license_release_date_blank";
  public static final String LICENSE_YEARS_NOT_ENOUGH = "license_years_not_enough";
  public static final String LOCALIZED_DESCRIPTION = "localized_description";
  public static final String MISSING_PARAMS = "missing_params";
  public static final String PAYMENT_ERROR = "payment_error";
  public static final String PROFILE_IMCOMPLETE = "profile_incomplete";
  public static final String REQUEST_GONE = "error_gone";
  public static final String REQUEST_TIMEOUT = "error_request_timeout";
  public static final String SERVER = "error_server";
  public static final String SIGN_IN = "sign_in_error";
  public static final String UNAUTHORIZED = "error_unauthorized";
  public static final String UNCONFIRMED_USER = "unconfirmed_user";
  public static final String USER_NOT_FOUND = "user_not_found";
  private String attribute;
  private String code;
  private String localized_description;
  private String model;

  public String getAttribute()
  {
    return this.attribute;
  }

  public String getCode()
  {
    return this.code;
  }

  public String getLocalizedDescription()
  {
    return this.localized_description;
  }

  public String getModel()
  {
    return this.model;
  }

  public void setAttribute(String paramString)
  {
    this.attribute = paramString;
  }

  public void setCode(String paramString)
  {
    this.code = paramString;
  }

  public void setLocalizedDescription(String paramString)
  {
    this.localized_description = paramString;
  }

  public void setModel(String paramString)
  {
    this.model = paramString;
  }

  public String toString()
  {
    String str = "";
    if (!TextUtils.isEmpty(this.code))
      str = str + "code: " + this.code + ", ";
    if (!TextUtils.isEmpty(this.localized_description))
      str = str + "localized_description: " + this.localized_description + ", ";
    if (!TextUtils.isEmpty(this.model))
      str = str + "model: " + this.model + ", ";
    if (!TextUtils.isEmpty(this.attribute))
      str = str + "attribute: " + this.attribute;
    return str;
  }

  public class ErrorList
  {
    public ErrorList()
    {
    }
  }
}
