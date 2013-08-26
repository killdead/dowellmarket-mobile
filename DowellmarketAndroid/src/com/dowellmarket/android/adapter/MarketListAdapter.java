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

  public Object getItem(int paramInt)
  {
    return this.markets.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return ((Market)this.markets.get(paramInt)).getId().longValue();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new ViewHolder();
      paramView = this.mInflater.inflate(2130903107, null);
    /*  ViewHolder.access$102(localViewHolder, (ImageView)paramView.findViewById(2131230814));
      ViewHolder.access$202(localViewHolder, (ImageView)paramView.findViewById(2131230973));
      ViewHolder.access$302(localViewHolder, (ImageView)paramView.findViewById(2131230894));
      ViewHolder.access$402(localViewHolder, (TextView)paramView.findViewById(2131230868));
      ViewHolder.access$502(localViewHolder, (TextView)paramView.findViewById(2131230823));
      ViewHolder.access$602(localViewHolder, (TextView)paramView.findViewById(2131230766));
      ViewHolder.access$702(localViewHolder, (TextView)paramView.findViewById(2131230852));
      ViewHolder.access$802(localViewHolder, (TextView)paramView.findViewById(2131230974));
      ViewHolder.access$902(localViewHolder, (TextView)paramView.findViewById(2131230803));
      ViewHolder.access$1002(localViewHolder, (TextView)paramView.findViewById(2131230815));
      ViewHolder.access$1102(localViewHolder, paramView.findViewById(2131230975));
      */
      paramView.setTag(localViewHolder);
      Market localMarket = (Market)this.markets.get(paramInt);
      String str1 = null;
     /* if (localCar.getPhotos().size() > 0)
        str1 = localCar.getMainPhoto().getThumbUrl();
      Boolean localBoolean = Boolean.valueOf(localCar.getIsPhoneNumberVisible());
      Float localFloat1 = Float.valueOf(localCar.getDistance());
      String str2 = localCar.getAvailabilityStatus();
      String str3 = localCar.getTitle();
      String str4 = localCar.getCity();
      Integer localInteger1 = localCar.getStats().getRatingsCount();
      Float localFloat2 = localCar.getStats().getRatingsAverage();
      Integer localInteger2 = Integer.valueOf(localCar.getRoundedPrice());
      if (TextUtils.isEmpty(str3))
        break label598;
      localViewHolder.title.setText(str3);
      label324: if ((localInteger2 == null) || (localInteger2.intValue() <= 0))
        break label611;
      localViewHolder.price.setText(Utils.toCurrency(localInteger2.intValue()));
      label353: if (this.mFilters.isDateTimeDistanceFiltersSet())
        localViewHolder.slashJ.setVisibility(8);
      if (TextUtils.isEmpty(str4))
        break label624;
      localViewHolder.city.setText(str4);
      label391: if ((localFloat2 != null) && (localFloat2.floatValue() > 0.0F))
        BitmapUtils.displayRatingsStars(localViewHolder.ratingsStars, localFloat2);
      localViewHolder.ratingsCount.setText("(" + localInteger1 + ")");
      this.mImageLoader.displayImage(str1, localViewHolder.carPhoto, this.mDisplayImageOptions);
      if (!localBoolean.booleanValue())
        break label637;
      localViewHolder.call.setVisibility(0);
      label486: if (TextUtils.isEmpty(str2))
        break label687;
      if ((!str2.equals("booked")) && (!str2.equals("unavailable")))
        break label664;
      if (!str2.equals("booked"))
        break label650;
      localViewHolder.availabilityStatus.setText(2131492901);
      label538: localViewHolder.availabilityStatus.setVisibility(0);
      localViewHolder.mask.setVisibility(0);
      label556: if ((localFloat1 == null) || (localFloat1.floatValue() < 0.0F))
        break label710;
      localViewHolder.distance.setText(Utils.distanceConverter(localFloat1));
    */}
    
      
      localViewHolder = (ViewHolder)paramView.getTag();
    /*  break;
      label598: localViewHolder.title.setVisibility(8);
      break label324;
      label611: localViewHolder.price.setVisibility(8);
      break label353;
      label624: localViewHolder.city.setVisibility(8);
      break label391;
      label637: localViewHolder.call.setVisibility(8);
      break label486;
      label650: localViewHolder.availabilityStatus.setText(2131492902);
      break label538;
      label664: localViewHolder.mask.setVisibility(8);
      localViewHolder.availabilityStatus.setVisibility(8);
      break label556;
      label687: localViewHolder.mask.setVisibility(8);
      localViewHolder.availabilityStatus.setVisibility(8);
      break label556;
      label710: localViewHolder.distance.setVisibility(8);*/
   
      return paramView;
  }

  private class ViewHolder
  {
   /* private TextView availabilityStatus;
    private ImageView call;
    private ImageView carPhoto;
    private TextView city;
    private TextView distance;
    private View mask;
    private TextView price;
    private TextView ratingsCount;
    private ImageView ratingsStars;
    private TextView slashJ;
    private TextView title;
*/
    private ViewHolder()
    {
    }
  }
}

/* Location:           C:\Users\Utilisateur\Documents\Dev\ApkToJar\tools\classes-dex2jar.jar
 * Qualified Name:     com.drivy.android.adapter.CarListAdapter
 * JD-Core Version:    0.6.0
 */