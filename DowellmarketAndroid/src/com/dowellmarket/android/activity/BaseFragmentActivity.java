package com.dowellmarket.android.activity;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.dowellmarket.android.HomeActivity;
import com.dowellmarket.android.R;
import com.dowellmarket.android.adapter.NavigationDrawerAdapter;
import com.dowellmarket.android.fragment.ProgressDialogFragment;
import com.dowellmarket.android.http.Api;
import com.dowellmarket.android.util.ErrorDisplay;


public class BaseFragmentActivity extends ActionBarActivity 
implements  AdapterView.OnItemClickListener {
  protected boolean actionBarEnabled = true;
  protected Api mApi;
  protected boolean mCancellableProgress = true;
  protected Context mContext;
  
  private DrawerLayout mDrawerLayout;
  private ListView mDrawerList;
  private ActionBarDrawerToggle mDrawerToggle;
  
  protected Bundle mExtras;
  protected Intent mIntent;
  protected ProgressDialogFragment mProgressDialogFragment;
  protected Resources mRes;
  protected final int mTitleRes;

  public BaseFragmentActivity()
  {
    this.mTitleRes = R.string.app_name;
  }

  public BaseFragmentActivity(int paramInt)
  {
    this.mTitleRes = paramInt;
  }
  
  public void onCreate(Bundle paramBundle, int paramInt)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_base);
   FrameLayout localFrameLayout = (FrameLayout)findViewById(R.id.content_frame);
    LayoutInflater.from(this).inflate(paramInt, localFrameLayout, true);
    this.mContext = this;
    this.mRes = getResources();
    this.mExtras = getIntent().getExtras();
    //this.mApi = new Api(this.mContext, this);
    _setNavigationDrawer();
  }

  private void _setNavigationDrawer()
  {
    if (this.actionBarEnabled)
    {
      this.mDrawerLayout = ((DrawerLayout)findViewById(R.id.drawer_layout));
      this.mDrawerList = ((ListView)findViewById(R.id.left_drawer));
      NavigationDrawerAdapter localNavigationDrawerAdapter = new NavigationDrawerAdapter(this.mContext);
      this.mDrawerList.setAdapter(localNavigationDrawerAdapter);
      this.mDrawerList.setOnItemClickListener(this);
      this.mDrawerToggle = new BaseFragmentActivityToggle(this, this.mDrawerLayout, R.drawable.ic_drawer, R.string.navigation_drawer_accessibility_open, R.string.navigation_drawer_accessibility_close);
      //this.mDrawerToggle = new BaseFragmentActivityToggle(this, this, this.mDrawerLayout, 2130837693, 2131493079, 2131493078);
      this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      getSupportActionBar().setHomeButtonEnabled(true);
      getSupportActionBar().setTitle(this.mTitleRes);
    }
  }
  
  public void onBackPressed()
  {
    //this.mApi.interruptRequests();
    super.onBackPressed();
  }
  

  protected boolean isNavigationDrawerOpen()
  {
    if ((this.mDrawerLayout != null) && (this.mDrawerList != null) && (this.mDrawerLayout.isDrawerOpen(this.mDrawerList)))
     return true;
    
    return false;
  }
/*
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      this.mApi.getProfile();
      Toast.makeText(this.mContext, 2131493000, Toast.LENGTH_LONG).show();
    }
    else
    {
    	super.onActivityResult(paramInt1, paramInt2, paramIntent);
      
    }
  }

  public void onApiRequestFailure(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    ErrorDisplay.show(this.mContext, paramInt2, paramString1, paramString2);
  }

  public void onApiRequestFinish(int paramInt)
  {
    showProgress(false);
  }

  public void onApiRequestStart(int paramInt)
  {
    showProgress(true);
  }

  public void onApiRequestSuccess(int paramInt1, int paramInt2, String paramString)
  {
    showProgress(false);
    switch (paramInt1)
    {
    default:
    case 2:
    case 9:
    case 11:
    }
    while (true)
    {
      return;
      this.mIntent = new Intent(this.mContext, ProfileShowActivity.class);
      this.mIntent.putExtra("user", paramString);
      this.mContext.startActivity(this.mIntent);
      continue;
      this.mIntent = new Intent(this.mContext, RentalsConfirmActivity.class);
      this.mContext.startActivity(this.mIntent);
      continue;
      if (TextUtils.isEmpty(paramString))
        continue;
      User localUser = User.fromString(paramString);
      if (localUser == null)
        continue;
      com.drivy.android.model.Settings.getInstance().setUserApiToken(localUser.getApiToken());
      PushNotificationsCenter.enable(this.mContext);
      setResult(-1);
      finish();
    }
  }

 

  public void onCancel(ProgressDialogFragment paramProgressDialogFragment, int paramInt)
  {
    this.mApi.interruptRequests();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mDrawerToggle != null)
      this.mDrawerToggle.onConfigurationChanged(paramConfiguration);
  }

 
*/
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramPosition, long paramId)
  {
   // String str = getClass().getSimpleName();
    toggleDrawer();
    switch (paramView.getId())
    { 
    case -1:
    case -2:
    case -3:
    case -4:
    case -5:
    case -6:
    default:
    }
    
    Toast.makeText(this.mContext,"Position : "+paramPosition+" Id: "+paramId, Toast.LENGTH_LONG).show();
/*
      if (str.equals(HomeActivity.class.getSimpleName()))
        continue;
      this.mIntent = new Intent(this.mContext, HomeActivity.class);
      startActivity(this.mIntent);
      continue;
      if (str.equals(CarsNewActivity.class.getSimpleName()))
        continue;
      this.mIntent = new Intent(this.mContext, CarsNewActivity.class);
      startActivity(this.mIntent);
      continue;
      this.mIntent = new Intent(this.mContext, RentalsListActivity.class);
      startActivity(this.mIntent);
      continue;
      if (User.isLogged(this.mContext).booleanValue())
      {
        if (str.equals(ProfileShowActivity.class.getSimpleName()))
          continue;
        this.mApi.getProfile();
        continue;
      }
      if (str.equals(SessionsNewActivity.class.getSimpleName()))
        continue;
      this.mIntent = new Intent(this.mContext, SessionsNewActivity.class);
      startActivityForResult(this.mIntent, 1);
      continue;
      if (str.equals(PagesHowItWorksActivity.class.getSimpleName()))
        continue;
      this.mIntent = new Intent(this.mContext, PagesHowItWorksActivity.class);
      startActivity(this.mIntent);*/
    
  }
  
  protected void toggleDrawer()
  {
    if ((this.mDrawerLayout != null) && (this.mDrawerList != null))
    {
      if (this.mDrawerLayout.isDrawerOpen(this.mDrawerList)) 
         this.mDrawerLayout.closeDrawer(this.mDrawerList);
    }
    else
    {
      this.mDrawerLayout.openDrawer(this.mDrawerList);
    }
  }

  /*public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
	  boolean bool = super.onOptionsItemSelected(paramMenuItem); 
    
     
      toggleDrawer();
      return bool;
  }

  /*protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (this.mDrawerToggle != null)
      this.mDrawerToggle.syncState();
  }*/

  /*public void onResume()
  {
    super.onResume();
  //  com.facebook.Settings.publishInstallAsync(this, this.mRes.getString(2131493040));
  }

  protected void showProgress(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mProgressDialogFragment != null)
      {
        this.mProgressDialogFragment.dismissAllowingStateLoss();
        this.mProgressDialogFragment = null;
      }
      this.mProgressDialogFragment = ProgressDialogFragment.newInstance(0, this.mRes.getString(this.mApi.getLoadingMessageRes()), this.mCancellableProgress);
      this.mProgressDialogFragment.show(getSupportFragmentManager(), "show_progress");
    }
    else
    {
      this.mProgressDialogFragment.dismissAllowingStateLoss();
    }
  }*/

 
}
