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

  public static void show(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if ((paramString1.equals("user_not_found")) || (paramString1.equals("invalid_password")))
        DISPLAY_TYPE = "DIALOG";
      if ((paramString1.equals("unconfirmed_user")) || (paramString1.equals("deleted_user")))
        DISPLAY_TYPE = "DIALOG";
      if ((paramString1.equals("sign_in_error")) || (paramString1.equals("age_not_enough")))
        DISPLAY_TYPE = "DIALOG";
      if (paramString1.equals("license_years_not_enough"))
        DISPLAY_TYPE = "DIALOG";
    }
    if (DISPLAY_TYPE.equals("TOAST"))
      Toast.makeText(paramContext.getApplicationContext(), paramString2, Toast.LENGTH_LONG).show();
    else {
      AlertDialog localAlertDialog = new AlertDialog.Builder(paramContext).create();
      localAlertDialog.setTitle(2131493020);
      localAlertDialog.setMessage(paramString2);
      localAlertDialog.setButton(-1, paramContext.getResources().getString(2131493107), new ErrorDisplayClickListener());
      localAlertDialog.show();
    }
  }
}
