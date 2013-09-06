package com.dowellmarket.android.model;

import android.text.TextUtils;
import com.google.gson.Gson;

public class Model
{
	public String status;
	
  public static <T> Object fromString(String paramString, Class<T> paramClass)
  {
	  Object localObject = null;
    if (!TextUtils.isEmpty(paramString))
     localObject = new Gson().fromJson(paramString, paramClass);
      return localObject;
  }
  
  public static StandardResponse getStandardResponse(String paramString) {
	  
	  

	  StandardResponse localObject = null;
	  
	  if (!TextUtils.isEmpty(paramString))
	    localObject = (StandardResponse) new Gson().fromJson(paramString, StandardResponse.class); 
  
  return localObject;
  }
  
 


  public String toString()
  {
    return new Gson().toJson(this);
  }
  

  public class StandardResponse {
	  
		public int status;
		 public String message;
		public String result;
		
	}
  
}


