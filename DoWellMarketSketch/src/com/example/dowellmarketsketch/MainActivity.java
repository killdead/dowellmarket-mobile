package com.example.dowellmarketsketch;

import java.util.ArrayList;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
	public static final String PREFS_NAME = "LoginPrefs";
	private ViewPager mViewPager;
	private ActionBar mSupportActionBar;
	protected ListFragment mFrag;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		 SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
			if (!settings.getString("logged", "").toString().equals("logged")) {
				Intent intent = new Intent(MainActivity.this, LoginActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				finish();
			}
		
		initTabsPager();
		
		initSideLeftMenu(savedInstanceState);
		
 
	}
	
	
	private void initSideLeftMenu(Bundle savedInstanceState) {
		setBehindContentView(R.layout.left_side_menu);
        getSlidingMenu().setBehindOffset(100);
        setSlidingActionBarEnabled(true);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = new SideMenuListFragment();
			t.replace(R.id.left_side_menu, mFrag);
			t.commit();
		} else {
			 mFrag = (ListFragment)this.getSupportFragmentManager().findFragmentById(R.id.left_side_menu);
		}
		
	}


	
	 /**
     * Initialises the Views and variables for this activity.
     */
    private void initTabsPager() {
        
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
        
               getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
    /**
     * Adapter for setting the content for the tab click's.
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


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Collapsible Action Item
		menu.add("Search").setIcon(android.R.drawable.ic_menu_search)
		                  .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		                  
		
		menu.add("New").setIcon(android.R.drawable.ic_menu_add)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);


	    // OverFlow menu in actionbar.
	   /* SubMenu submenu = menu.addSubMenu("");
	    submenu.setIcon( R.drawable.abs__ic_menu_moreoverflow_normal_holo_dark);

	    submenu.add(1, 0, 1, "Cut");
	    submenu.add(1, 1, 2, "Copy");
	    submenu.add(1, 2, 3, "Paste");
	    submenu.getItem(). setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS|
	                         MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	    // end overflow menu
*/
	   return true;
	}
	
	
	
	}
	
	
	

