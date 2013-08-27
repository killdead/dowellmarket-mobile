package com.dowellmarket.android.model;

import com.dowellmarket.android.util.PersistentData;

public class Settings
{
  public static final String PREF_MAP_DISPLAY_MODE_LISTING = "mode_listing";
  public static final String PREF_MAP_DISPLAY_MODE_LOCATION = "mode_location";
  private PersistentData mData = PersistentData.getInstance();
  private SettingsObject mSettings;

  private Settings()
  {
    String str = this.mData.getSettings();
    if (str != null)
    this.mSettings = ((SettingsObject)SettingsObject.fromString(str, SettingsObject.class)); 
  }

  public static Settings getInstance()
  {
    return SettingsHolder.instance;
  }

  public String getMapDisplayMode()
  {
    return this.mSettings.mapDisplayMode;
  }

  public String getUserApiToken()
  {
    return this.mSettings.userApiToken;
  }

  public String getUserAuthToken()
  {
    return this.mSettings.userAuthToken;
  }

  public String getUserEmail()
  {
    return this.mSettings.userEmail;
  }
  
  public String getUserLogin()
  {
    return this.mSettings.userLogin;
  }


  public boolean hasApiToken()
  {
    if (this.mSettings.userApiToken != null)
      return true;
      
      return false;
  }

  public boolean hasAuthToken()
  {
    if (this.mSettings.userAuthToken != null)
    	 return true;
    
    return false;
  }

  public void save()
  {
    this.mData.setSettings(this.mSettings.toString());
  }

  public void setMapDisplayMode(String paramString)
  {
    SettingsObject.fromString(paramString,SettingsObject.class);
    save();
  }

  public void setUserApiToken(String paramString)
  {
	  SettingsObject.fromString(paramString,SettingsObject.class);
    save();
  }

  public void setUserAuthToken(String paramString)
  {
	  SettingsObject.fromString(paramString,SettingsObject.class);
    save();
  }

  public void setUserEmail(String paramString)
  {
	SettingsObject.fromString(paramString,SettingsObject.class);
    save();
  }

  private static class SettingsHolder
  {
    private static final Settings instance = new Settings();
  }

  private class SettingsObject extends Model
  {
    private String mapDisplayMode;
    private String userApiToken;
    private String userAuthToken;
    private String userEmail;
    private String userLogin;

    private SettingsObject()
    {
    }
  }
}

