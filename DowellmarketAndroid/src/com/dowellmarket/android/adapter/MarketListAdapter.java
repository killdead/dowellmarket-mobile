package com.dowellmarket.android.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.dowellmarket.android.R;
import com.dowellmarket.android.model.Filters;
import com.dowellmarket.android.model.Market;

public class MarketListAdapter extends BaseAdapter
{
  private final List<Market> markets;
 // private DisplayImageOptions mDisplayImageOptions;
  private Filters mFilters = Filters.getInstance();
 // private ImageLoader mImageLoader;
  private final LayoutInflater mInflater;

  public MarketListAdapter(Context paramContext, List<Market> paramList)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    this.markets = paramList;
//    this.mImageLoader = ImageLoader.getInstance();
  //  this.mImageLoader.init(ImageLoaderConfiguration.createDefault(paramContext));
    //_setImageOptions();
  }

  /*private void _setImageOptions()
  {
    this.mDisplayImageOptions = new DisplayImageOptions.Builder().showStubImage(2130837735).showImageForEmptyUri(2130837735).resetViewBeforeLoading().cacheInMemory().cacheOnDisc().build();
  }*/

  public int getCount()
  {
    return this.markets.size();
  }

  public Market getItem(int paramInt)
  {
    return this.markets.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return ((Market)this.markets.get(paramInt)).getGuid();
  }

  public View getView(int position, View convertView, ViewGroup parent)
  {
    
    if (convertView == null)
    {
    	ViewHolder localViewHolder = new ViewHolder();
    	convertView = this.mInflater.inflate(R.layout.partial_item_market, null);
      localViewHolder.guid = (TextView)convertView.findViewById(R.id.guid);
      localViewHolder.name = (TextView)convertView.findViewById(R.id.name);
      convertView.setTag(localViewHolder);
    
    }
    
    ViewHolder localViewHolder = (ViewHolder) convertView.getTag();
    Market m = getItem(position);
    localViewHolder.guid.setText(String.valueOf(m.getGuid()));
    localViewHolder.name.setText(m.getName());

   
      return convertView;
  }

  private class ViewHolder
  {
   private TextView guid;
   private TextView name;
  }
}