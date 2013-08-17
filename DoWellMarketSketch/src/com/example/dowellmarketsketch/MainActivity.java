package com.example.dowellmarketsketch;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.example.dowellmarketsketch.model.WebServiceStandardResponse;
import com.example.dowellmarketsketch.webservice.UserWebService;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {
	private ViewPager mViewPager;
	private ActionBar mSupportActionBar;
	protected ListFragment mFrag;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		initTabsPager();
		
		initSideLeftMenu(savedInstanceState);
		 TestConnect();		
 
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
	
	
	public void TestConnect() {
		new AsyncTask<Void, Void, WebServiceStandardResponse>() {
			
			final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
	    	//Context mcontext;
	    	
			
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				dialog.setMessage("Test webservice ...");
			    dialog.show();
			}

			@Override
			protected WebServiceStandardResponse doInBackground(Void... params) {
				UserWebService webService = new UserWebService();

				WebServiceStandardResponse response = webService.Connect("admin", "adminadmin");

				if (response != null) {
					return response;
				}

				return new WebServiceStandardResponse();
			}

			protected void onPostExecute(WebServiceStandardResponse result) {
             
				if(result.status==0) {
				
					 //finish();
					 
					//dialog.setMessage("Connexion OK, token= : "+result.result);
				dialog.dismiss();
					 
				Toast.makeText(MainActivity.this,"Connexion OK, token : "+ result.result,  Toast.LENGTH_LONG).show();
				}
				else {
					 
					dialog.setMessage("Erreur de connexion : "+result.message);
					//Toast.makeText(MainActivity.this, result.message,  Toast.LENGTH_LONG).show();
					
					//dialog.dismiss();
				}
				
					
				}
				
			}.execute();

		}
	}
	
	
	

