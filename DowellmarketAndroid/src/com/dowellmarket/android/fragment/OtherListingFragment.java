package com.dowellmarket.android.fragment;

import android.os.Bundle;

public class OtherListingFragment extends CategoryListingFragment {

	
	 @Override
	  public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState); 
	      this.mFilters.setCategory("autres");
	  }
}
