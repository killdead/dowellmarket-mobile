package com.example.dowellmarketsketch;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
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
		
		 menuitem = new SideMenuItem("Mes alertes", R.drawable.abs__ic_go);		
		adapter.add(menuitem);
		
		 menuitem = new SideMenuItem("Préférences", R.drawable.abs__ic_go);		
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

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(R.layout.side_menu_item, null);
			}
			TextView title = (TextView) convertView.findViewById(R.id.side_menu_item_tag);
			title.setText(getItem(position).tag);
            title.setCompoundDrawablesWithIntrinsicBounds(getItem(position).iconRes, 0, 0, 0);
            return convertView;
		}

	}
}
