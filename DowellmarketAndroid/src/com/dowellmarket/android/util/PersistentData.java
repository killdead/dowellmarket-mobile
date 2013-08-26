package com.dowellmarket.android.util;

import android.content.SharedPreferences;
import com.dowellmarket.android.app.Application;


public class PersistentData
{
  public static final String FILENAME = "persistent_data";
  @SuppressWarnings("unused")
private static final String SETTINGS_KEY = "settings";
  private static SharedPreferences mSharedPreferences;
  private static SharedPreferences.Editor mSharedPreferencesEditor;
  private String settings;

  public PersistentData()
  {
    mSharedPreferences = Application.getContext().getSharedPreferences("persistent_data", 0);
    mSharedPreferencesEditor = mSharedPreferences.edit();
    if (mSharedPreferences != null)
      this.settings = mSharedPreferences.getString("settings", null);
  }

  public static PersistentData getInstance()
  {
    return PersistentDataHolder.instance;
  }

  public String getSettings()
  {
    return this.settings;
  }

  public void setSettings(String paramString)
  {
    this.settings = paramString;
    mSharedPreferencesEditor.putString("settings", paramString);
    mSharedPreferencesEditor.commit();
  }

  private static class PersistentDataHolder
  {
    private static final PersistentData instance = new PersistentData();
  }
}