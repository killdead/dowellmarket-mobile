package com.dowellmarket.android.model;


import com.dowellmarket.android.LoginActivity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;


public class User extends Model
{
  public static final String EXTRA = "user";
  public static final String PREF_API_TOKEN = "api_token";
  public static final String PREF_EMAIL = "email";
  public static final String PREF_USERNAME = "username";
  public static final String PREF_ID = "id";
  private String about_me;
  private String address_line1;
  private String address_line2;
  private String api_token;
  private String auth_token;
  private String city;
  private String country;
  private String created_at;
  private String email;
  private String username;
  private String first_name;
  private Integer id;
  private String last_name;
  private String password;
  private String phone_number;
  private String postal_code;
  private String public_name;
  //private UserStats stats;
  private String tmp_remote_avatar_url;

  public static Boolean disconnect(Context paramContext)
  {
    Settings localSettings = Settings.getInstance();
    localSettings.setUserApiToken(null);
    localSettings.setUserAuthToken(null);
   
    CookieSyncManager.createInstance(paramContext);
    CookieManager.getInstance().removeAllCookie();
    CookieSyncManager.getInstance().sync();
    Intent localIntent = new Intent(paramContext, LoginActivity.class);
    localIntent.addFlags(67108864);
    paramContext.startActivity(localIntent);
    return true;
  }

  public static User fromString(String paramString)
  {
    return (User)Model.fromString(paramString, User.class);
  }

  public static Boolean isLogged(Context paramContext)
  {
    if (Settings.getInstance().hasApiToken());
    for (Boolean localBoolean = Boolean.valueOf(true); ; localBoolean = Boolean.valueOf(false))
      return localBoolean;
  }

  public String getAboutMe()
  {
    return this.about_me;
  }

  public String getAddressLine1()
  {
    return this.address_line1;
  }

  public String getAddressLine2()
  {
    return this.address_line2;
  }

  public String getApiToken()
  {
    Settings localSettings = Settings.getInstance();
    if (localSettings.hasApiToken())
      this.api_token = localSettings.getUserApiToken();
    return this.api_token;
  }

  public String getAuthToken()
  {
    return this.auth_token;
  }

  public String getCity()
  {
    return this.city;
  }

  public String getCountry()
  {
    return this.country;
  }

  public String getCreatedAt()
  {
    return "";//return DateUtils.getDate(this.created_at, "yyyy-MM-dd'T'HH:mm:ss'Z'", "dd/MM/yyyy");
  }

  public String getEmail()
  {
    this.email = Settings.getInstance().getUserEmail();
    return this.email;
  }

  public String getFirstName()
  {
    return this.first_name;
  }

  public String getFullName()
  {
    if ((!TextUtils.isEmpty(this.first_name)) && (!TextUtils.isEmpty(this.last_name)));
    for (String str = this.first_name + " " + this.last_name; ; str = null)
      return str;
  }

  public Integer getId()
  {
    return this.id;
  }

  public String getLastName()
  {
    return this.last_name;
  }

  public String getPassword()
  {
    return this.password;
  }

  public String getPhoneNumber()
  {
    return this.phone_number;
  }

  public String getPostalCode()
  {
    return this.postal_code;
  }

  public String getPublicName()
  {
	  String str = getFullName();
    if ((!TextUtils.isEmpty(this.public_name)) && (!TextUtils.isEmpty(getFullName())));
      str = this.public_name;
      
      return str;
  }

  public void setAboutMe(String paramString)
  {
    this.about_me = paramString;
  }

  public void setAddressLine1(String paramString)
  {
    this.address_line1 = paramString;
  }

  public void setAddressLine2(String paramString)
  {
    this.address_line2 = paramString;
  }

  public void setApiToken(String paramString)
  {
    this.api_token = paramString;
  }

  public void setAuthToken(String paramString)
  {
    this.auth_token = paramString;
  }

  public void setCity(String paramString)
  {
    this.city = paramString;
  }

  public void setCountry(String paramString)
  {
    this.country = paramString;
  }

  public void setCreatedAt(String paramString)
  {
    this.created_at = paramString;
  }

  public void setEmail(String paramString)
  {
    Settings.getInstance().setUserEmail(paramString);
    this.email = paramString;
  }

  

  public void setFirstName(String paramString)
  {
    this.first_name = paramString;
  }

  public void setId(Integer paramInteger)
  {
    this.id = paramInteger;
  }

  public void setLastName(String paramString)
  {
    this.last_name = paramString;
  }

 
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }

  public void setPhoneNumber(String paramString)
  {
    this.phone_number = paramString;
  }

  public void setPostalCode(String paramString)
  {
    this.postal_code = paramString;
  }

  public void setPublicName(String paramString)
  {
    this.public_name = paramString;
  }


  public void setTmpRemoteAvatarUrl(String paramString)
  {
    this.tmp_remote_avatar_url = paramString;
  }

public void setLogin(String paramString) {
	this.username = paramString;
	
}
}

