package com.dowellmarket.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.dowellmarket.android.adapter.MarketListAdapter;
import com.dowellmarket.android.http.Api;
import com.dowellmarket.android.http.ApiResponse;
import com.dowellmarket.android.model.Filters;
import com.dowellmarket.android.model.SearchMarket;
import android.content.res.Resources;

public class CategoryListingFragment extends Fragment
implements  ApiResponse.OnApiResponseListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnClickListener
{
 private ListView marketList;
 private MarketListAdapter marketListAdapter;
  
  private Api mApi;
  private int firstVisibleItem;
  private OnListingListener listener;
  private Context mContext;
  protected Filters mFilters = Filters.getInstance();
  private ProgressBar mFooterProgress;
  private TextView mFooterTextView;
  private RelativeLayout mFooterView;
  private LayoutInflater mLayoutInflater;
  private SearchMarket mSearch;
  private LinearLayout noResultLayout;
  private boolean scrolled = false;
  private int totalItemCount;
  private int visibleItemCount = 0;
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);  
      
  }
  
  @Override
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_listing, paramViewGroup, false);
  }
  
  @Override
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mContext =  getActivity();
    this.mLayoutInflater = getLayoutInflater(paramBundle);
    this.marketList = ((ListView)paramView.findViewById(R.id.market_list));
    this.noResultLayout = ((LinearLayout)paramView.findViewById(R.id.layout_no_results));
    this.mFooterView = ((RelativeLayout)this.mLayoutInflater.inflate(R.layout.partial_footer, null));
    this.mFooterTextView = ((TextView)this.mFooterView.findViewById(R.id.footer));
    this.mFooterProgress = ((ProgressBar)this.mFooterView.findViewById(R.id.footer_progress));
    this.marketList.addFooterView(this.mFooterView, null, false);
    this.marketList.setOnItemClickListener(this);
    this.marketList.setOnScrollListener(this);
    this.mFooterTextView.setOnClickListener(this);
    this.mApi = new Api(this.mContext, this);
    processSearch();
  }
  
  

  public void onClick(View paramView)
  {
		/*if (    (paramView.getId() == R.id.footer)
				&& (this.totalItemCount % Constants.PAGE_SIZE.intValue() == 0)
				&& (this.mSearch.getTotal().intValue() > Constants.PAGE_SIZE.intValue())
				&& (this.firstVisibleItem + this.visibleItemCount == this.totalItemCount)
				&& (!this.scrolled)
				&& (this.mSearch.getResults().size() < this.mSearch.getTotal().intValue()))
		{
			int i = 1 + this.totalItemCount / Constants.PAGE_SIZE.intValue();
			if (this.listener != null) {
				this.scrolled = true;
				this.mFooterProgress.setVisibility(0);
				this.listener.onScroll(i);
			}
		}*/
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

  public void processSearch()
  {
	  Log.i("CategoryListing Process Search","Request Search");
     this.mFooterProgress.setVisibility(4);
     this.noResultLayout.setVisibility(8);
     this.marketList.setVisibility(8);
     this.mApi.getSearch();
     
    
     
     /* if ((this.mSearch != null) && (this.mFilters.getPage() != null) && (this.mFilters.getPage().intValue() > 1) && (this.mSearch.getResults().size() < this.mSearch.getTotal().intValue()) && (!TextUtils.isEmpty(paramString)))
    {
      SearchMarket localSearch = SearchMarket.fromString(paramString);
      this.mSearch.merge(localSearch);
      if ((this.mSearch == null) || (this.mSearch.getResults() == null) || (this.mSearch.getTotal() == null) || (this.mSearch.getResults().size() <= 0) || (this.mSearch.getTotal().intValue() <= 0))
        break label287;
      this.marketListAdapter = new marketListAdapter(this.mContext, this.mSearch.getResults());
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
      this.marketList.setVisibility(0);
    }
   else
    {*/
      
      
      
      
    //} 
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

  
  public void setOnListingListener(OnListingListener paramOnListingListener)
  {
    this.listener = paramOnListingListener;
  }

  public static abstract interface OnListingListener
  {
    public abstract void onMarketSelected(Long paramLong, Float paramFloat, String paramString);

    public abstract void onScroll(int paramInt);
  }

@Override
public void onApiRequestFailure(int RequestCode, int statusCode,
		String httpError, String appError) {
	Log.i("CategoryListing","Request failure");
	
}

@Override
public void onApiRequestFinish(int RequestCode) {
	// TODO Auto-generated method stub
	Log.i("CategoryListing onApiRequestFinish","start finish");
}

@Override
public void onApiRequestStart(int RequestCode) {
	// TODO Auto-generated method stub
	Log.i("CategoryListing onApiRequestStart","start request");
	 
	
}


@Override
public void onApiRequestSuccess(int RequestCode, int statusCode,
		String paramString) {
	Log.i("CategoryListing onApiRequestSuccess"," paramString = "+paramString);
	this.mSearch = SearchMarket.fromString(paramString);
	
 if(this.mSearch != null) {
	 this.marketListAdapter = new MarketListAdapter(this.mContext, this.mSearch.getResults());
     this.marketList.setAdapter(this.marketListAdapter);
    	 TextView localTextView = this.mFooterTextView;
         Resources localResources = this.mContext.getResources();
         Object[] arrayOfObject = new Object[2];
         arrayOfObject[0] = Integer.valueOf(this.mSearch.getResults().size());
         arrayOfObject[1] = this.mSearch.getTotal();
         localTextView.setText(localResources.getString(R.string.search_results, arrayOfObject));
    	 this.noResultLayout.setVisibility(8);
         this.marketList.setVisibility(0);
     }
     else
     {
    	 this.noResultLayout.setVisibility(0);
         this.marketList.setVisibility(8);
     }
}
}
