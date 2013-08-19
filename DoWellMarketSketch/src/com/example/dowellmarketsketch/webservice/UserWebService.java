package com.example.dowellmarketsketch.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;

import com.example.dowellmarketsketch.model.WebServiceStandardResponse;

public class UserWebService extends WebService {
	
private final String UrlAuthenticate = "http://192.168.0.12/elgg/services/api/rest/json/?method=auth.gettoken";
//private final String UrlGetTest = "http://192.168.0.12/elgg/services/api/rest/json/?method=system.api.list";


public UserWebService() {
	super();
}



public WebServiceStandardResponse Connect(String username, String password) {
	WebServiceStandardResponse r = null;
	String inputStream = null;
	try {
		// Envoie de la requête
				
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("username",username));
	    params.add(new BasicNameValuePair("password",password));
	    		
		inputStream = Post(UrlAuthenticate,params);
		
		
	} catch (Exception e) {
		e.printStackTrace();
		Log.e("WebService", "Impossible de rapatrier les données ");
	}
	
	if(inputStream != null) {
		 r = gson.fromJson(inputStream, WebServiceStandardResponse.class);
        Log.i("dowellmarket","status = "+r.status);
	}
	
	
	return r;
}


}
