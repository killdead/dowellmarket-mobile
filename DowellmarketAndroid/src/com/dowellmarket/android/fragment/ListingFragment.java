package com.dowellmarket.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dowellmarket.android.R;
import com.dowellmarket.android.model.Filters;
import com.dowellmarket.android.model.SearchMarket;
import com.dowellmarket.android.util.Constants;

public class ListingFragment extends Fragment
  implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnClickListener
{
  private ListView marketList;
 // private CarListAdapter carListAdapter;
  private int firstVisibleItem;
  private OnListingListener listener;
  private Context mContext;
  private Filters mFilters = Filters.getInstance();
  private ProgressBar mFooterProgress;
  private TextView mFooterTextView;
  private RelativeLayout mFooterView;
  private LayoutInflater mLayoutInflater;
  private SearchMarket mSearch;
  private LinearLayout noResultLayout;
  private boolean scrolled = false;
  private int totalItemCount;
  private int visibleItemCount = 0;

  public void onClick(View paramView)
  {
    /*if ((paramView.getId() == R.id.footer) && (this.totalItemCount % Constants.PAGE_SIZE.intValue() == 0) && (this.mSearch.getTotal().intValue() > Constants.PAGE_SIZE.intValue()) && (this.firstVisibleItem + this.visibleItemCount == this.totalItemCount) && (!this.scrolled) && (this.mSearch.getResults().size() < this.mSearch.getTotal().intValue()))
    {
      int i = 1 + this.totalItemCount / Constants.PAGE_SIZE.intValue();
      if (this.listener != null)
      {
        this.scrolled = true;
        this.mFooterProgress.setVisibility(0);
        this.listener.onScroll(i);
      }
    }*/
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_listing, paramViewGroup, false);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
   /* if ((this.listener != null) && (paramInt < this.mSearch.getResults().size()))
    {
      Float localFloat = Float.valueOf(((Market)this.mSearch.getResults().get(paramInt)).getPrice());
      String str = ((Car)this.mSearch.getResults().get(paramInt)).getAvailabilityStatus();
      this.listener.onCarSelected(Long.valueOf(paramLong), localFloat, str);
    }*/
  }

  public void onResponse(String paramString)
  {
   /* this.mFooterProgress.setVisibility(4);
    if ((this.mSearch != null) && (this.mFilters.getPage() != null) && (this.mFilters.getPage().intValue() > 1) && (this.mSearch.getResults().size() < this.mSearch.getTotal().intValue()) && (!TextUtils.isEmpty(paramString)))
    {
      SearchMarket localSearch = SearchMarket.fromString(paramString);
      this.mSearch.merge(localSearch);
      if ((this.mSearch == null) || (this.mSearch.getResults() == null) || (this.mSearch.getTotal() == null) || (this.mSearch.getResults().size() <= 0) || (this.mSearch.getTotal().intValue() <= 0))
        break label287;
      this.carListAdapter = new CarListAdapter(this.mContext, this.mSearch.getResults());
      this.carList.setAdapter(this.carListAdapter);
      if (this.scrolled)
      {
        this.carList.setSelection(this.firstVisibleItem);
        this.scrolled = false;
      }
      TextView localTextView = this.mFooterTextView;
      Resources localResources = this.mContext.getResources();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.mSearch.getResults().size());
      arrayOfObject[1] = this.mSearch.getTotal();
      localTextView.setText(localResources.getString(2131493190, arrayOfObject));
      this.noResultLayout.setVisibility(8);
      this.carList.setVisibility(0);
    }
    while (true)
    {
      return;
      this.mSearch = Search.fromString(paramString);
      break;
      label287: this.noResultLayout.setVisibility(0);
      this.carList.setVisibility(8);
    }*/
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
   /* this.totalItemCount = (paramInt3 - this.carList.getFooterViewsCount());
    if (paramInt1 == 0);
    for (int i = 0; ; i = paramInt1 - this.carList.getFooterViewsCount())
    {
      this.firstVisibleItem = i;
      this.visibleItemCount = paramInt2;
      return;
    }*/
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
   /* if ((this.mSearch != null) && (this.mSearch.getResults() != null) && (this.totalItemCount % Constants.PAGE_SIZE.intValue() == 0) && (this.mSearch.getTotal().intValue() > Constants.PAGE_SIZE.intValue()) && (this.firstVisibleItem + this.visibleItemCount == this.totalItemCount) && (paramInt != 1) && (!this.scrolled) && (this.mSearch.getResults().size() < this.mSearch.getTotal().intValue()))
    {
      int i = 1 + this.totalItemCount / Constants.PAGE_SIZE.intValue();
      if (this.listener != null)
      {
        this.scrolled = true;
        this.mFooterProgress.setVisibility(0);
        this.listener.onScroll(i);
      }
    }*/
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mContext = getActivity();
    this.mLayoutInflater = getLayoutInflater(paramBundle);
    //this.carList = ((ListView)paramView.findViewById(2131230959));
   // this.noResultLayout = ((LinearLayout)paramView.findViewById(2131230960));
   // this.mFooterView = ((RelativeLayout)this.mLayoutInflater.inflate(2130903106, null));
    //this.mFooterTextView = ((TextView)this.mFooterView.findViewById(2131230970));
    //this.mFooterProgress = ((ProgressBar)this.mFooterView.findViewById(2131230969));
    //this.carList.addFooterView(this.mFooterView, null, false);
    //this.carList.setOnItemClickListener(this);
    //this.carList.setOnScrollListener(this);
    //this.mFooterTextView.setOnClickListener(this);
  }

  public void setOnListingListener(OnListingListener paramOnListingListener)
  {
    this.listener = paramOnListingListener;
  }

  public static abstract interface OnListingListener
  {
    public abstract void onCarSelected(Long paramLong, Float paramFloat, String paramString);

    public abstract void onScroll(int paramInt);
  }
}
