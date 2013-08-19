package com.example.dowellmarketsketch;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SideMenuListFragment extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		SideMenuAdapter adapter = new SideMenuAdapter(getActivity());
		
		SideMenuItem menuitem = new SideMenuItem("Mon profil", R.drawable.abs__ic_go);		
		adapter.add(menuitem);
		
		 menuitem = new SideMenuItem("Mes annonces", R.drawable.abs__ic_go);		
		adapter.add(menuitem);
		
		 menuitem = new SideMenuItem("Mes alertes", android.R.drawable.ic_popup_reminder);		
		adapter.add(menuitem);
		
		 menuitem = new SideMenuItem("Préférences", android.R.drawable.ic_menu_preferences);		
		adapter.add(menuitem);
		
		 menuitem = new SideMenuItem("Se déconnecter", android.R.drawable.ic_lock_power_off);		
			adapter.add(menuitem);
			
		
		
		setListAdapter(adapter);
	}

	private class SideMenuItem {
		public String tag;
		public int iconRes;
		
		public SideMenuItem(String tag, int iconRes) {
			this.tag = tag; 
			this.iconRes = iconRes;
		}
	}

	public class SideMenuAdapter extends ArrayAdapter<SideMenuItem> {

		public SideMenuAdapter(Context context) {
			super(context, 0);
		}

	@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.side_menu_item, null);
			}
			TextView title = (TextView) convertView.findViewById(R.id.side_menu_item_tag);
			title.setText(getItem(position).tag);
            title.setCompoundDrawablesWithIntrinsicBounds(getItem(position).iconRes, 0, 0, 0);
            
            title.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Log.i("Click", "TextView clicked on row " + position);
                    if(position==4){
                    	SharedPreferences settings = getContext().getSharedPreferences("LoginPrefs",0);
                    	SharedPreferences.Editor editor = settings.edit();
                    	editor.remove("logged");
                    	editor.commit();
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    	
                    }
                    
                    //Toast.makeText(this,"Connexion OK, token : ",  Toast.LENGTH_LONG).show();
                }
            });
            
            return convertView;
		}

	}
}
