package com.dowellmarket.android.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import java.util.ArrayList;

public class MarketHomeAdapter extends FragmentPagerAdapter
  implements ActionBar.TabListener, ViewPager.OnPageChangeListener
{
  private final ActionBar mActionBar;
  private final Context mContext;
  private final ArrayList<TabInfo> mTabs = new ArrayList();
  private final ViewPager mViewPager;

  public MarketHomeAdapter(ActionBarActivity paramActionBarActivity, ViewPager paramViewPager)
  {
    super(paramActionBarActivity.getSupportFragmentManager());
    this.mContext = paramActionBarActivity;
    this.mActionBar = paramActionBarActivity.getSupportActionBar();
    this.mViewPager = paramViewPager;
    this.mViewPager.setAdapter(this);
    this.mViewPager.setOnPageChangeListener(this);
  }

  public void addTab(ActionBar.Tab paramTab, Class<?> paramClass, Bundle paramBundle)
  {
    TabInfo localTabInfo = new TabInfo(paramClass, paramBundle);
    paramTab.setTag(localTabInfo);
    paramTab.setTabListener(this);
    this.mTabs.add(localTabInfo);
    this.mActionBar.addTab(paramTab);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.mTabs.size();
  }

  public Fragment getItem(int position)
  {
    TabInfo localTabInfo = (TabInfo)this.mTabs.get(position);
    return Fragment.instantiate(this.mContext, localTabInfo.clss.getName(), localTabInfo.args);
  }

  public void onPageScrollStateChanged(int position)
  {
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int position)
  {
    this.mActionBar.setSelectedNavigationItem(position);
  }

  public void onTabReselected(Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
  }

  public void onTabSelected(Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
    Object localObject = paramTab.getTag();
    for (int i = 0; i < this.mTabs.size(); i++)
    {
      if (this.mTabs.get(i) != localObject)
        continue;
      this.mViewPager.setCurrentItem(i);
      
    }
  }

  public void onTabUnselected(Tab paramTab, FragmentTransaction paramFragmentTransaction)
  {
  }

  static final class TabInfo
  {
    private final Bundle args;
    private final Class<?> clss;

    TabInfo(Class<?> paramClass, Bundle paramBundle)
    {
      this.clss = paramClass;
      this.args = paramBundle;
    }
  }



}
