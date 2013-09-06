package com.dowellmarket.android.activity;


import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.dowellmarket.android.R;
import com.dowellmarket.android.adapter.MarketHomeAdapter;
import com.dowellmarket.android.fragment.ApartementListingFragment;
import com.dowellmarket.android.fragment.CategoryListingFragment;
import com.dowellmarket.android.fragment.HouseListingFragment;
import com.dowellmarket.android.fragment.ListingFragment;
import com.dowellmarket.android.fragment.OtherListingFragment;
import com.dowellmarket.android.fragment.WalletListingFragment;


public class HomeActivity extends BaseFragmentActivity {
	private ViewPager mViewPager;
	private MarketHomeAdapter mMarketHomeAdapter;
	public HomeActivity()
	  {
	    super();
	  }
	
	public void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle, R.layout.activity_home);
	    this.mViewPager = ((ViewPager)findViewById(R.id.homePager));
	    this.mMarketHomeAdapter = new MarketHomeAdapter(this, this.mViewPager);
	   
	    this.mMarketHomeAdapter.addTab(getSupportActionBar().newTab().setText(R.string.navigation_category_house), HouseListingFragment.class, null);
	    this.mMarketHomeAdapter.addTab(getSupportActionBar().newTab().setText(R.string.navigation_category_apartment), ApartementListingFragment.class, null);
	    this.mMarketHomeAdapter.addTab(getSupportActionBar().newTab().setText(R.string.navigation_category_wallet), WalletListingFragment.class,  null);
	    this.mMarketHomeAdapter.addTab(getSupportActionBar().newTab().setText(R.string.navigation_category_other), OtherListingFragment.class, null);
		    
	    this.mViewPager.setAdapter(this.mMarketHomeAdapter);
	    getSupportActionBar().setNavigationMode(2);
	    
	    
	  }
	

	/*@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}*/

}
