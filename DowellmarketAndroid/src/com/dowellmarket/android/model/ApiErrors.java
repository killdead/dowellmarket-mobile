package com.dowellmarket.android.model;

import java.util.ArrayList;

public class ApiErrors extends Model
{
  private ArrayList<ApiError> errors;

  public static ApiErrors fromString(String paramString)
  {
    return (ApiErrors)Model.fromString(paramString, ApiErrors.class);
  }

  public ArrayList<ApiError> getErrors()
  {
    return this.errors;
  }

  public ApiError getFirstError()
  {
    ApiError localApiError = null;
    if ((this.errors != null) && (this.errors.size() > 0))
      localApiError = (ApiError)this.errors.get(0);
    return localApiError;
  }

  public void setErrors(ArrayList<ApiError> paramArrayList)
  {
    this.errors = paramArrayList;
  }
}
