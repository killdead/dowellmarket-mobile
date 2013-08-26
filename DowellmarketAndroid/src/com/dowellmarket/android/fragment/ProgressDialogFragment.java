package com.dowellmarket.android.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;

public class ProgressDialogFragment extends DialogFragment
{
  private static final String CANCELABLE_EXTRA = "cancelable";
  private static final String ICON_EXTRA = "icon";
  private static final String ID_EXTRA = "id_extra";
  private static final String MESSAGE_EXTRA = "message";
  private static final String TITLE_EXTRA = "title";
  private ProgressDialogFragmentListener mListener;

  public static ProgressDialogFragment newInstance(int paramInt, String paramString)
  {
    return newInstance(paramInt, paramString, true, null, 0);
  }

  public static ProgressDialogFragment newInstance(int paramInt, String paramString, boolean paramBoolean)
  {
    return newInstance(paramInt, paramString, paramBoolean, null, 0);
  }

  public static ProgressDialogFragment newInstance(int paramInt, String paramString1, boolean paramBoolean, String paramString2)
  {
    return newInstance(paramInt, paramString1, paramBoolean, paramString2, 0);
  }

  public static ProgressDialogFragment newInstance(int paramInt1, String paramString1, boolean paramBoolean, String paramString2, int paramInt2)
  {
    ProgressDialogFragment localProgressDialogFragment = new ProgressDialogFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("cancelable", paramBoolean);
    localBundle.putInt("id_extra", paramInt1);
    localBundle.putInt("icon", paramInt2);
    localBundle.putString("title", paramString2);
    localBundle.putString("message", paramString1);
    localProgressDialogFragment.setArguments(localBundle);
    return localProgressDialogFragment;
  }

  public void dismiss()
  {
   
      super.dismiss();
      
  }

  public void dismissAllowingStateLoss()
  {
   
      super.dismissAllowingStateLoss();
      
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    try
    {
      this.mListener = ((ProgressDialogFragmentListener)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
    
        Log.w("ProgressDialogFragmentListener", paramActivity.toString() + " not implement ProgressDialogFragmentListener");
    }
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool = getArguments().getBoolean("cancelable", true);
    int i = getArguments().getInt("icon", 0);
    int j = getArguments().getInt("id_extra", 0);
    String str1 = getArguments().getString("title");
    String str2 = getArguments().getString("message");
    ProgressDialog localProgressDialog = new ProgressDialog(getActivity());
    if (i != 0)
      localProgressDialog.setIcon(i);
    if (!TextUtils.isEmpty(str2))
      localProgressDialog.setMessage(str2);
    if (!TextUtils.isEmpty(str1))
      localProgressDialog.setTitle(str1);
    localProgressDialog.setCancelable(bool);
    if (bool)
      localProgressDialog.setOnCancelListener(
    		  new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramDialogInterface)
        {
          try
          {
            ProgressDialogFragment.this.mListener.onCancel(ProgressDialogFragment.this,paramDialogInterface.hashCode());
            return;
          }
          catch (Exception localException)
          {
            while (true)
              Log.w("ProgressDialogFragmentListener", "Cancel button pressed but " + ProgressDialogFragment.this.getActivity().toString() + " not implement ProgressDialogFragmentListener");
          }
        }
      });
    return localProgressDialog;
  }

  public void setProgressDialogFragmentListener(ProgressDialogFragmentListener paramProgressDialogFragmentListener)
  {
    this.mListener = paramProgressDialogFragmentListener;
  }

  public void show(FragmentManager paramFragmentManager, String paramString)
  {
   
      super.show(paramFragmentManager, paramString);
    
  }

  public static abstract interface ProgressDialogFragmentListener
  {
    public abstract void onCancel(ProgressDialogFragment paramProgressDialogFragment, int paramInt);
  }

}
