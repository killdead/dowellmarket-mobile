package com.dowellmarket.android.adapter.item;

public class NavigationDrawerItem
{
  private int drawable;
  private int title;

  public NavigationDrawerItem(int paramInt1, int paramInt2)
  {
    this.drawable = paramInt1;
    this.title = paramInt2;
  }

  public int getDrawable()
  {
    return this.drawable;
  }

  public int getTitle()
  {
    return this.title;
  }
}
