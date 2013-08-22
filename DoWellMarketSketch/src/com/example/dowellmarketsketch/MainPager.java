package com.example.dowellmarketsketch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.actionbarsherlock.app.SherlockListFragment;


public class MainPager extends SherlockListFragment {
	 ArrayAdapter<String> adapter;
	 /** An array of items to display in ArrayList */
    String apple_versions[] = new String[]{
        "Mountain Lion",
        "Lion",
        "Snow Leopard",
        "Leopard",
        "Tiger",
        "Panther",
        "Jaguar",
        "Puma"
    };
    
    String apple_versions2[] = new String[]{
            "$$ Mountain Lion",
            "$$ Lion",
            "$$ Snow Leopard",
            "Leopard",
            "Tiger",
            "Panther",
            "Jaguar",
            "Puma"
        };
    
    String apple_versions3[] = new String[]{
            "$$$$ Mountain Lion",
            "$$** Lion",
            "$$$$ Snow Leopard",
            "Leopard",
            "Tiger",
            "Panther",
            "Jaguar",
            "Puma"
        };
     
     
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    	int pos = getArguments().getInt("pos");
    	 if(getArguments() != null)
	        {
    		 switch (pos) {
			case 0:
				  adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, apple_versions);
				  
				break;
			case 1:
				  adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, apple_versions2);
				  
				break;
			default:
				adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, apple_versions3);
				  
				break;
			}
	        }
    	
    	/** Creating array adapter to set data in listview */
    
        /** Setting the array adapter to the listview */
        setListAdapter(adapter);
 
        return super.onCreateView(inflater, container, savedInstanceState);
    }
	
	
	/*protected ListFragment mFrag;
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		 View view = inflater.inflate(R.layout.mainpager, null);
	        if(getArguments() != null)
	        {
	        	
	        	
	      //  	FragmentTransaction t = this.getFragmentManager().beginTransaction();
			//	mFrag = new MainPagerListFragment();
				//t.replace(R.id.mainpager_list, mFrag);
			//	t.commit();
	        	
	        	
	            String text = getArguments().getString("text");
	            ((TextView)view.findViewById(R.id.mainpager_txt)).setText(text);
	            
	         //   ListView lview = (ListView) view.findViewById(R.id.mainpager_list);
	            
	          /*   	FragmentTransaction t = this.getFragmentManager().beginTransaction();
					mFrag = new MainPagerListFragment();
					t.replace(R.id.mainpager_list, mFrag);
					t.commit();*/
	            
	            
	    //    }
	    //    return this.getView();
		//return view;
		//return inflater.inflate(R.layout.fragment_1, container, false);
	//}*/

}
