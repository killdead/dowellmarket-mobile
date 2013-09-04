package com.dowellmarket.android.model;

import java.util.HashMap;

import com.loopj.android.http.RequestParams;

import android.text.TextUtils;

public class Filters
{
  public static final int DISTANCE_DEFAULT = 200;
  private static final String FILTER_MARKET_CATEGORY = "all";
  private String marketCategory;
  private RequestParams requestParams;
  private Filters()
  {
    
  }

  

  public static Filters getInstance()
  {
    return FiltersHolder.instance;
  }

 
  /*public boolean isDateTimeDistanceFiltersSet()
  {
    if ((!TextUtils.isEmpty(this.startDate)) || (!TextUtils.isEmpty(this.startTime)) || (!TextUtils.isEmpty(this.endTime)) || (!TextUtils.isEmpty(this.endDate)));
    for (int i = 1; ; i = 0)
      return i;
  }*/

  public String getCategory()
  {
    return this.marketCategory;
  }
  
  public void setCategory(String paramString)
  {
    this.marketCategory = paramString;  
  }

  

  public String toUrl()
  {
    String str1 = "";
    
    if (!TextUtils.isEmpty(this.marketCategory))
        str1 = str1 + "category/" + this.marketCategory ;
    else
    	str1 = str1 + "category/" + FILTER_MARKET_CATEGORY;
    
    
    return str1.substring(0, -1 + str1.length());
  }
  
  public RequestParams getRequestParam() {
	
	  
	  HashMap<String, String> Map = new HashMap<String, String>();
  	Map.put("method", "market.get_markets");  
	  
	  if (!TextUtils.isEmpty(this.marketCategory))
	    {
	    	
		  Map.put("context", this.marketCategory); 
	    }
	    
	  requestParams = new RequestParams(Map);
	    
	  
	  return requestParams;
  }

  private static class FiltersHolder
  {
    private static final Filters instance = new Filters();
  }
}

