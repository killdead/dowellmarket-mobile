package com.dowellmarket.android.util;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

public class ErrorDisplay
{
  private static String DISPLAY_TYPE = "TOAST";
  @SuppressWarnings("unused")
private static final String DISPLAY_TYPE_DIALOG = "DIALOG";
  @SuppressWarnings("unused")
private static final String DISPLAY_TYPE_TOAST = "TOAST";

  public static void show(Context paramContext, int paramInt, String httpError, String appError)
  {
    if (httpError != null)
    {
      if ((httpError.equals("user_not_found")) || (httpError.equals("invalid_password")))
        DISPLAY_TYPE = "DIALOG";
      if ((httpError.equals("unconfirmed_user")) || (httpError.equals("deleted_user")))
        DISPLAY_TYPE = "DIALOG";
      if ((httpError.equals("sign_in_error")) || (httpError.equals("age_not_enough")))
        DISPLAY_TYPE = "DIALOG";
      if (httpError.equals("license_years_not_enough"))
        DISPLAY_TYPE = "DIALOG";
    }
    if (DISPLAY_TYPE.equals("TOAST"))
      Toast.makeText(paramContext.getApplicationContext(), appError, Toast.LENGTH_LONG).show();
    else {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramContext).create();
      localAlertDialog.setTitle("Erreur");
      localAlertDialog.setMessage(appError);
     
      localAlertDialog.setButton(-1, "TextButton", new ErrorDisplayClickListener());
      localAlertDialog.show();
    }
  }
}
