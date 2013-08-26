package com.dowellmarket.android.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;

public class AlertDialogFragment extends DialogFragment
{
  private static final String BUTTON_NEGATIVE_EXTRA = "button_negative";
  private static final String BUTTON_POSITIVE_EXTRA = "button_positive";
  private static final String ICON_EXTRA = "icon";
  private static final String ID_EXTRA = "id_extra";
  private static final String MESSAGE_EXTRA = "message";
  private static final String TITLE_EXTRA = "title";
  private AlertDialogFragmentListener mListener;

  public static AlertDialogFragment newInstance(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Context paramContext)
  {
    return newInstance(paramInt1, paramContext.getString(paramInt2), paramContext.getString(paramInt3), paramContext.getString(paramInt4), paramContext.getString(paramInt5), 0);
  }

  public static AlertDialogFragment newInstance(int paramInt, String paramString)
  {
    return newInstance(paramInt, paramString, null, null, null, 0);
  }

  public static AlertDialogFragment newInstance(int paramInt, String paramString1, String paramString2)
  {
    return newInstance(paramInt, paramString1, paramString2, null, null, 0);
  }

  public static AlertDialogFragment newInstance(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return newInstance(paramInt, paramString1, paramString2, paramString3, paramString4, 0);
  }

  public static AlertDialogFragment newInstance(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AlertDialogFragment localAlertDialogFragment = new AlertDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("id_extra", paramInt1);
    localBundle.putInt("icon", paramInt2);
    localBundle.putString("title", paramString2);
    localBundle.putString("message", paramString1);
    localBundle.putString("button_positive", paramString3);
    localBundle.putString("button_negative", paramString4);
    localAlertDialogFragment.setArguments(localBundle);
    return localAlertDialogFragment;
  }

  public void dismiss()
  {
   super.dismiss();
    
  }

  public void dismissAllowingStateLoss()
  {
    try
    {
      super.dismissAllowingStateLoss();
      
    }
    catch (Exception localException)
    {
      
    }
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.mListener = ((AlertDialogFragmentListener)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      
        Log.w("AlertDialogFragmentListener", paramActivity.toString() + " not implement AlertDialogFragmentListener");
    }
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getArguments().getInt("icon", 0);
    int j = getArguments().getInt("id_extra", 0);
    String str1 = getArguments().getString("title");
    String str2 = getArguments().getString("message");
    String str3 = getArguments().getString("button_positive");
    String str4 = getArguments().getString("button_negative");
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getActivity());
    if (i != 0)
      localBuilder.setIcon(i);
    if (!TextUtils.isEmpty(str2))
      localBuilder.setMessage(str2);
    if (!TextUtils.isEmpty(str1))
      localBuilder.setTitle(str1);
    if (!TextUtils.isEmpty(str3))
      localBuilder.setPositiveButton(str3, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          try
          {
            AlertDialogFragment.this.mListener.onDialogPositiveClick(AlertDialogFragment.this, paramInt);
            return;
          }
          catch (Exception localException)
          {
           
              Log.w("AlertDialogFragmentListener", "Button positive pressed but " + AlertDialogFragment.this.getActivity().toString() + " not implement AlertDialogFragmentListener");
          }
        }
      });
    if (!TextUtils.isEmpty(str4))
      localBuilder.setNegativeButton(str4, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramDialogInterface, int paramInt)
        {
          try
          {
            AlertDialogFragment.this.mListener.onDialogNegativeClick(AlertDialogFragment.this, paramInt);
            return;
          }
          catch (Exception localException)
          {
         
              Log.w("AlertDialogFragmentListener", "Button negative pressed but " + AlertDialogFragment.this.getActivity().toString() + " not implement AlertDialogFragmentListener");
          }
        }
      });
    return localBuilder.create();
  }

  public void setAlertDialogFragmentListener(AlertDialogFragmentListener paramAlertDialogFragmentListener)
  {
    this.mListener = paramAlertDialogFragmentListener;
  }

  public void show(FragmentManager paramFragmentManager, String paramString)
  {
    try
    {
      super.show(paramFragmentManager, paramString);
     return;
    }
    catch (Exception localException)
    {
      
    }
  }

  public static abstract interface AlertDialogFragmentListener
  {
    public abstract void onDialogNegativeClick(AlertDialogFragment paramAlertDialogFragment, int paramInt);

    public abstract void onDialogPositiveClick(AlertDialogFragment paramAlertDialogFragment, int paramInt);
  }
}
