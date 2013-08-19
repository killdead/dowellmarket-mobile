package com.example.dowellmarketsketch.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.google.gson.Gson;
public class WebService {

	
    protected Gson gson;
	
    private DefaultHttpClient client = new DefaultHttpClient();  

	public WebService() {
		gson = new Gson();
	}
	
	
	   public String Get(String url) {
	       
	        HttpPost getRequest = new HttpPost(url);
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
		    params.add(new BasicNameValuePair("username","admin"));
		    params.add(new BasicNameValuePair("password","adminadmin"));
	        
	      try {
	         
	    	  getRequest.setEntity(new UrlEncodedFormEntity(params));
	         HttpResponse getResponse = client.execute(getRequest);	
	         final int statusCode = getResponse.getStatusLine().getStatusCode();

	
	         if (statusCode != HttpStatus.SC_OK) {
	            Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);
	            return null;	
	         }
	
	         HttpEntity getResponseEntity = getResponse.getEntity();
	
	         if (getResponseEntity != null) {
	            return EntityUtils.toString(getResponseEntity);	
	         }

	      }
	
	      catch (IOException e) {
	         getRequest.abort();
	         Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
	      }
	
	      return null;       
	
	   }
	   

	   public String Post(String url,List<NameValuePair> params) {
	       
	        HttpPost getRequest = new HttpPost(url);
	        
	        
	      try {
	         
	    	  getRequest.setEntity(new UrlEncodedFormEntity(params));
	         HttpResponse getResponse = client.execute(getRequest);	
	         final int statusCode = getResponse.getStatusLine().getStatusCode();

	
	         if (statusCode != HttpStatus.SC_OK) {
	            Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);
	            return null;	
	         }
	
	         HttpEntity getResponseEntity = getResponse.getEntity();
	
	         if (getResponseEntity != null) {
	            return EntityUtils.toString(getResponseEntity);	
	         }

	      }
	
	      catch (IOException e) {
	         getRequest.abort();
	         Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
	      }
	
	      return null;       
	
	   }
	
	
	
}
