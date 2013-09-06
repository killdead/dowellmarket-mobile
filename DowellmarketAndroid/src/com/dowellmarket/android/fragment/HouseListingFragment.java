package com.dowellmarket.android.fragment;

import com.dowellmarket.android.model.Filters;

import android.os.Bundle;

public class HouseListingFragment extends CategoryListingFragment {

	
	 @Override
	  public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState); 
	      this.mFilters.setCategory("maison");
	  }
}
