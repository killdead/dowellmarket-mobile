package com.dowellmarket.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.dowellmarket.android.R;
import com.dowellmarket.android.adapter.item.NavigationDrawerItem;


public class NavigationDrawerAdapter extends BaseAdapter
{
  /*public static final int CAR_NEW = -2;
  public static final int HELP_POSITION = -5;
  public static final int MY_PROFILE_POSITION = -4;
  public static final int RENTALS_LIST = -3;
  public static final int SEARCH_POSITION = -1;*/
  private ArrayList<NavigationDrawerItem> items;
  private int[] itemsDrawable;
  private int[] itemsId;
  private int[] itemsString;
  private final Context mContext;

  public NavigationDrawerAdapter(Context paramContext)
  {
    int[] arrayOfInt1 = new int[6];
    arrayOfInt1[0] = -1;
    arrayOfInt1[1] = -2;
    arrayOfInt1[2] = -3;
    arrayOfInt1[3] = -4;
    arrayOfInt1[4] = -5;
    arrayOfInt1[5] = -6;
    this.itemsId = arrayOfInt1;
    int[] arrayOfInt2 = new int[6];
    arrayOfInt2[0] = R.string.navigation_drawer_my_profile;
    arrayOfInt2[1] = R.string.navigation_drawer_my_market;
    arrayOfInt2[2] = R.string.navigation_drawer_market_new;
    arrayOfInt2[3] = R.string.navigation_drawer_my_alert;
    arrayOfInt2[4] = R.string.navigation_drawer_setttings;
    arrayOfInt2[5] = R.string.navigation_drawer_my_help;
    this.itemsString = arrayOfInt2;
    int[] arrayOfInt3 = new int[6];
    arrayOfInt3[0] = R.drawable.ic_person;
    arrayOfInt3[1] = android.R.drawable.ic_menu_gallery;
    arrayOfInt3[2] = android.R.drawable.ic_menu_add;
    arrayOfInt3[3] = android.R.drawable.ic_menu_manage;
    arrayOfInt3[4] = android.R.drawable.ic_menu_preferences;
    arrayOfInt3[5] = android.R.drawable.ic_menu_help;
    this.itemsDrawable = arrayOfInt3;
    this.items = new ArrayList<NavigationDrawerItem>();
    this.mContext = paramContext;
    for (int i = 0; i < this.itemsString.length; i++)
    {
      NavigationDrawerItem localNavigationDrawerItem = new NavigationDrawerItem(this.itemsDrawable[i], this.itemsString[i]);
      this.items.add(localNavigationDrawerItem);
    }
  }

  public int getCount()
  {
    return this.items.size();
  }

  public NavigationDrawerItem getItem(int paramInt)
  {
    return (NavigationDrawerItem)this.items.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return this.itemsId[paramInt];
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new ViewHolder();
      paramView = LayoutInflater.from(this.mContext).inflate(R.layout.partial_item_navigation_drawer, null);
      paramView.setId((int)getItemId(paramInt));
      localViewHolder.text =  (TextView)paramView.findViewById(R.id.textNavigationDrawer);
      paramView.setTag(localViewHolder);
    }
    
      localViewHolder = (ViewHolder)paramView.getTag();
      localViewHolder.text.setText(getItem(paramInt).getTitle());
      localViewHolder.text.setCompoundDrawablesWithIntrinsicBounds(getItem(paramInt).getDrawable(), 0, 0, 0);      
      
    
    return paramView;
  }

  private class ViewHolder
  {
    private TextView text;

    private ViewHolder()
    {
    }
  }
}