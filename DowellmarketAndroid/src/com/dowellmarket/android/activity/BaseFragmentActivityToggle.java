package com.dowellmarket.android.activity;

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

class BaseFragmentActivityToggle extends ActionBarDrawerToggle
{
  public BaseFragmentActivityToggle(Activity activity,
			DrawerLayout drawerLayout, int drawerImageRes,
			int openDrawerContentDescRes, int closeDrawerContentDescRes) {
		super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes,
				closeDrawerContentDescRes);
	}

public void onDrawerClosed(View paramView)
  {
    super.onDrawerClosed(paramView);
  }

  public void onDrawerOpened(View paramView)
  {
    super.onDrawerOpened(paramView);
  }
}

