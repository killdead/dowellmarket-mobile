package com.dowellmarket.android.model;

import android.text.TextUtils;
import com.google.gson.Gson;

public class Model
{
  public static <T> Object fromString(String paramString, Class<T> paramClass)
  {
	  Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
     localObject = new Gson().fromJson(paramString, paramClass);
      return localObject;
  }

  public String toString()
  {
    return new Gson().toJson(this);
  }
}
