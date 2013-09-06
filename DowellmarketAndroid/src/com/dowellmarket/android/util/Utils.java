package com.dowellmarket.android.util;

import java.util.Locale;

import android.text.TextUtils;

public class Utils
{


  public static String getDigitsOnly(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    	return paramString;
    
    StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < paramString.length(); i++)
      {
        char c = paramString.charAt(i);
        if (!Character.isDigit(c))
          continue;
        localStringBuffer.append(c);
      }
    
      return localStringBuffer.toString();
  }

  


  public static String sanitize(String paramString)
  {
    return paramString.toLowerCase(Locale.FRANCE).trim();
  }

  public static String toCurrency(float paramFloat)
  {
    return String.valueOf(paramFloat) + " &#8364;";
  }

  public static String toCurrency(int paramInt)
  {
    return String.valueOf(paramInt) + "€";
  }
}