package com.example.dowellmarketsketch;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {
	private ViewPager mViewPager;
	private ActionBar mSupportActionBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		init();
	}
	
	 /**
     * Initialises the Views and variables for this activity.
     */
    private void init() {
        
        //  Initialise and set viewpager to the activity.
        mViewPager = new ViewPager(this);
        mViewPager.setId(1232);
        setContentView(mViewPager);
        
        //  Init and set ActionBar Properties.
        mSupportActionBar = getSupportActionBar();
        mSupportActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        //  Initialise Adapter for the view pager.
        SherlockTabAdapter adapter = new SherlockTabAdapter();
        ArrayList<Bundle> bundleAL = new ArrayList<Bundle>();
        String texts[] = {"Maison", "Appartement", "Porte-feuille", "Autres"};
        for(int index = 0; index < texts.length; index++)
        {
            //  Prepare Bundle object for each tab.
            Bundle bundle = new Bundle();
            bundle.putString("text", texts[index]);
            bundleAL.add(bundle);
            
            //  Add tabs for the action bar.
            ActionBar.Tab tab = mSupportActionBar.newTab().setText(texts[index])
                    .setTabListener(adapter);
            mSupportActionBar.addTab(tab);
        }
        
        adapter.setBundle(bundleAL);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(adapter);
    }
    
    /**
     * Adapter for setting the content for the tab click's.
     * 
     * @author shpolavarapu
     * 
     */
    private class SherlockTabAdapter extends FragmentPagerAdapter implements ActionBar.TabListener,
            ViewPager.OnPageChangeListener {

        private ArrayList<Bundle> mBundleAL;
        
        public SherlockTabAdapter() {
            super(getSupportFragmentManager());
        }
        
        /**
         * ArrayList of bundle's to pass as Arguments to Fragment.
         * @param bundleAL  ArrayList of bundle's
         */
        void setBundle(ArrayList<Bundle> bundleAL) {
            mBundleAL = bundleAL;
        }
        @Override
        public void onPageScrollStateChanged(int position) {
            
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int position) {
            //  Change the tab selection upon page selection.
            mSupportActionBar.setSelectedNavigationItem(position);
        }

        @Override
        public void onTabReselected(Tab arg0, FragmentTransaction arg1) {

        }

        @Override
        public void onTabSelected(Tab tab, FragmentTransaction arg1) {
            //  On Tab selection change the View Pager's Current item position. 
            mViewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {

        }

        @Override
        public Fragment getItem(int pos) {
            return Fragment.instantiate(MainActivity.this, Fragment_1.class.getName(), mBundleAL.get(pos));
        }

        @Override
        public int getCount() {
            return mBundleAL.size();
        }

    }


}
