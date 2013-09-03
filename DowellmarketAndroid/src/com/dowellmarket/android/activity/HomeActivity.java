package com.dowellmarket.android.activity;


import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.dowellmarket.android.R;
import com.dowellmarket.android.adapter.MarketHomeAdapter;
import com.dowellmarket.android.fragment.ListingFragment;


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
	    Bundle category = new Bundle();
	    category.putString("category","navigation_category_house");
	    this.mMarketHomeAdapter.addTab(getSupportActionBar().newTab().setText(R.string.navigation_category_house), ListingFragment.class, category);
	   
	    category = new Bundle();
	    category.putString("category","navigation_category_apartment");
	    this.mMarketHomeAdapter.addTab(getSupportActionBar().newTab().setText(R.string.navigation_category_apartment), ListingFragment.class, category);
	    
	    category = new Bundle();
	    category.putString("category","navigation_category_wallet");
	    this.mMarketHomeAdapter.addTab(getSupportActionBar().newTab().setText(R.string.navigation_category_wallet), ListingFragment.class,  category);
	 
	    category = new Bundle();
	    category.putString("category","navigation_category_other");
	    this.mMarketHomeAdapter.addTab(getSupportActionBar().newTab().setText(R.string.navigation_category_other), ListingFragment.class, category);
		    
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
