package com.dowellmarket.android.model;

import android.content.Context;
import android.location.Address;
import android.text.TextUtils;

public class Filters
{
  public static final int DISTANCE_DEFAULT = 200;
  private static final String FILTER_ADDRESS = "address";
  private static final String FILTER_CDW = "cdw";
  private static final String FILTER_END_DATE = "end_date";
  private static final String FILTER_END_TIME = "end_time";
  private static final String FILTER_IS_CITY = "is_city";
  private static final String FILTER_LATITUDE = "latitude";
  private static final String FILTER_LONGITUDE = "longitude";
  private static final String FILTER_NE_LATITUDE = "ne[latitude]";
  private static final String FILTER_NE_LONGITUDE = "ne[longitude]";
  private static final String FILTER_PAGE = "page";
  private static final String FILTER_PER = "per";
  private static final String FILTER_RADIUS = "radius";
  private static final String FILTER_RENTAL_DISTANCE = "rental_distance";
  private static final String FILTER_SORT_BY = "sort_by";
  private static final String FILTER_START_DATE = "start_date";
  private static final String FILTER_START_TIME = "start_time";
  private static final String FILTER_SW_LATITUDE = "sw[latitude]";
  private static final String FILTER_SW_LONGITUDE = "sw[longitude]";
  private String address;
  private Boolean cdw = Boolean.valueOf(false);
  private String endDate;
  private String endTime;
  private Integer isCity;
  private Long lastEdit;
  private Double latitude;
  private Double longitude;
  private Double neLatitude;
  private Double neLongitude;
  private Integer page;
  private Integer per;
  private Integer radius;
  private Integer rentalDistance;
  private String sortBy;
  private String startDate;
  private String startTime;
  private Double swLatitude;
  private Double swLongitude;

  private Filters()
  {
    _updateLastEdit();
  }

  private void _deletePositions()
  {
    this.latitude = null;
    this.longitude = null;
  }

  private void _deleteViewPortPositions()
  {
    this.neLatitude = null;
    this.neLongitude = null;
    this.swLatitude = null;
    this.swLongitude = null;
  }

  private void _updateLastEdit()
  {
    this.lastEdit = Long.valueOf(System.currentTimeMillis());
  }

  public static Filters getInstance()
  {
    return FiltersHolder.instance;
  }

  public void deleteAddress()
  {
    this.address = null;
    this.isCity = null;
  }

  public void deleteDatesDistance()
  {
    this.startDate = null;
    this.endDate = null;
    this.startTime = null;
    this.endTime = null;
    this.rentalDistance = null;
    _updateLastEdit();
  }

  public String getAddress()
  {
    return this.address;
  }

  public Boolean getCdw()
  {
    return this.cdw;
  }

  public String getEndDate()
  {
    return this.endDate;
  }

  public String getEndTime()
  {
    return this.endTime;
  }

  public Boolean getIsCity()
  {
  
    if (this.isCity.intValue() == 1)
    {    return true;
     
    }
    
    return false;
  }

  public Long getLastEdit()
  {
    return this.lastEdit;
  }

  public Double getLatitude()
  {
    return this.latitude;
  }

  public Double getLongitude()
  {
    return this.longitude;
  }

  public Double getNeLatitude()
  {
    return this.neLatitude;
  }

  public Double getNeLongitude()
  {
    return this.neLongitude;
  }

  public Integer getPage()
  {
    return this.page;
  }

  public Integer getPer()
  {
    return this.per;
  }

  public Integer getRadius()
  {
    return this.radius;
  }

  public Integer getRentalDistance()
  {
    return this.rentalDistance;
  }

  public String getSortBy()
  {
    return this.sortBy;
  }

  public String getStartDate()
  {
    return this.startDate;
  }

  public String getStartTime()
  {
    return this.startTime;
  }

  public Double getSwLatitude()
  {
    return this.swLatitude;
  }

  public Double getSwLongitude()
  {
    return this.swLongitude;
  }

  /*public boolean isDateTimeDistanceFiltersSet()
  {
    if ((!TextUtils.isEmpty(this.startDate)) || (!TextUtils.isEmpty(this.startTime)) || (!TextUtils.isEmpty(this.endTime)) || (!TextUtils.isEmpty(this.endDate)));
    for (int i = 1; ; i = 0)
      return i;
  }*/

  public void setAddress(String paramString)
  {
    this.address = paramString;
    _updateLastEdit();
  }

  public void setCdw(Boolean paramBoolean)
  {
    this.cdw = paramBoolean;
  }

  public void setEndDate(String paramString)
  {
    this.endDate = paramString;
    _updateLastEdit();
  }

  public void setEndTime(String paramString)
  {
    this.endTime = paramString;
    _updateLastEdit();
  }

  public void setEndTimeDefault(Context paramContext)
  {
    if (this.endTime == null)
      this.endTime = paramContext.getResources().getStringArray(2131034114)[1];
  }

  public void setIsCity(Address paramAddress)
  {
    this.isCity = Integer.valueOf(0);
    if ((paramAddress != null) && (TextUtils.isEmpty(paramAddress.getThoroughfare())) && (!TextUtils.isEmpty(paramAddress.getLocality())))
      this.isCity = Integer.valueOf(1);
    _updateLastEdit();
  }

  public void setLatitude(Double paramDouble)
  {
    _deleteViewPortPositions();
    this.latitude = paramDouble;
    _updateLastEdit();
  }

  public void setLongitude(Double paramDouble)
  {
    _deleteViewPortPositions();
    this.longitude = paramDouble;
    _updateLastEdit();
  }

  public void setNeLatitude(Double paramDouble)
  {
    _deletePositions();
    this.neLatitude = paramDouble;
    _updateLastEdit();
  }

  public void setNeLongitude(Double paramDouble)
  {
    _deletePositions();
    this.neLongitude = paramDouble;
    _updateLastEdit();
  }

  public void setPage(Integer paramInteger)
  {
    this.page = paramInteger;
    _updateLastEdit();
  }

  public void setPer(Integer paramInteger)
  {
    this.per = paramInteger;
    _updateLastEdit();
  }

  public void setRadius(Integer paramInteger)
  {
    this.radius = paramInteger;
    _updateLastEdit();
  }

  public void setRentalDistance(Integer paramInteger)
  {
    this.rentalDistance = paramInteger;
    _updateLastEdit();
  }

  public void setRentalDistanceDefault()
  {
    if (this.rentalDistance == null)
      this.rentalDistance = Integer.valueOf(200);
  }

  public void setSortBy(String paramString)
  {
    this.sortBy = paramString;
    _updateLastEdit();
  }

  public void setStartDate(String paramString)
  {
    this.startDate = paramString;
    _updateLastEdit();
  }

  public void setStartTime(String paramString)
  {
    this.startTime = paramString;
    _updateLastEdit();
  }

  public void setSwLatitude(Double paramDouble)
  {
    _deletePositions();
    this.swLatitude = paramDouble;
    _updateLastEdit();
  }

  public void setSwLongitude(Double paramDouble)
  {
    _deletePositions();
    this.swLongitude = paramDouble;
    _updateLastEdit();
  }

  public String toUrl()
  {
    String str1 = "?";
    if (!TextUtils.isEmpty(this.address))
      str1 = str1 + "address=" + this.address + "&";
    if (this.rentalDistance != null)
      str1 = str1 + "rental_distance=" + this.rentalDistance + "&";
    if (this.latitude != null)
      str1 = str1 + "latitude=" + this.latitude + "&";
    if (this.longitude != null)
      str1 = str1 + "longitude=" + this.longitude + "&";
    if (this.isCity != null)
      str1 = str1 + "is_city=" + this.isCity + "&";
    if (this.radius != null)
      str1 = str1 + "radius=" + this.radius + "&";
    if (!TextUtils.isEmpty(this.sortBy))
      str1 = str1 + "sort_by=" + this.sortBy + "&";
//    if (!TextUtils.isEmpty(this.startDate))
  //    str1 = str1 + "start_date=" + DateUtils.getDate(this.startDate, "dd/MM/yyyy", "yyyy-MM-dd") + "&";
    if (!TextUtils.isEmpty(this.startTime))
      str1 = str1 + "start_time=" + this.startTime + "&";
   // if (!TextUtils.isEmpty(this.endDate))
     // str1 = str1 + "end_date=" + DateUtils.getDate(this.endDate, "dd/MM/yyyy", "yyyy-MM-dd") + "&";
    if (!TextUtils.isEmpty(this.endTime))
      str1 = str1 + "end_time=" + this.endTime + "&";
    if (this.page != null)
      str1 = str1 + "page=" + this.page + "&";
    if (this.per != null)
      str1 = str1 + "per=" + this.per + "&";
    if (this.swLatitude != null)
      str1 = str1 + "sw[latitude]=" + this.swLatitude + "&";
    if (this.neLatitude != null)
      str1 = str1 + "ne[latitude]=" + this.neLatitude + "&";
    if (this.swLongitude != null)
      str1 = str1 + "sw[longitude]=" + this.swLongitude + "&";
    if (this.neLongitude != null)
      str1 = str1 + "ne[longitude]=" + this.neLongitude + "&";
    String str2 = str1 + "cdw=" + this.cdw + "&";
    return str2.substring(0, -1 + str2.length());
  }

  private static class FiltersHolder
  {
    private static final Filters instance = new Filters();
  }
}

