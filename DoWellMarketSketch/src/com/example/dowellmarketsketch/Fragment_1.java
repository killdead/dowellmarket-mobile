package com.example.dowellmarketsketch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Fragment_1 extends Fragment{
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		
		 View view = inflater.inflate(R.layout.fragment_1, null);
	        if(getArguments() != null)
	        {
	            String text = getArguments().getString("text");
	            ((TextView)view.findViewById(R.id.fragment_txt)).setText(text);
	        }
	        return view;
		
		//return inflater.inflate(R.layout.fragment_1, container, false);
	}

}
