package com.dowellmarket.android.activity;


import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.dowellmarket.android.R;
import com.dowellmarket.android.R.id;
import com.dowellmarket.android.R.layout;
import com.dowellmarket.android.adapter.MarketHomeAdapter;
import com.dowellmarket.android.fragment.ListingFragment;


public class HomeActivity extends BaseFragmentActivity {
	private ViewPager mViewPager;
	private MarketHomeAdapter mViewPagerAdapter;
	public HomeActivity()
	  {
	    super();
	  }
	
	public void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle, R.layout.activity_home);
	    this.mViewPager = ((ViewPager)findViewById(R.id.homePager));
	    this.mViewPagerAdapter = new MarketHomeAdapter(this, this.mViewPager);
	    this.mViewPagerAdapter.addTab(getSupportActionBar().newTab().setText("Tab 1"), ListingFragment.class, null);
	    this.mViewPagerAdapter.addTab(getSupportActionBar().newTab().setText("Tab 2"), ListingFragment.class, null);
	    this.mViewPagerAdapter.addTab(getSupportActionBar().newTab().setText("Tab 3"), ListingFragment.class, null);
	    this.mViewPagerAdapter.addTab(getSupportActionBar().newTab().setText("Tab 4"), ListingFragment.class, null);
		    
	    this.mViewPager.setAdapter(this.mViewPagerAdapter);
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
