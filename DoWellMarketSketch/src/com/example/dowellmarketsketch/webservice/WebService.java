package com.example.dowellmarketsketch.webservice;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.google.gson.Gson;
public class WebService {

	
    protected Gson gson;
    public static final String WebServiceBaseUrl = "http://192.168.0.12/elgg";
	
    private DefaultHttpClient client = null; 
    

	public WebService() {
		gson = new Gson();
	}
	
	public boolean isAvailable()
	{
		 HttpGet getRequest = new HttpGet(WebServiceBaseUrl);
		 final HttpParams httpParams = new BasicHttpParams();
		    HttpConnectionParams.setConnectionTimeout(httpParams, 2000);
		    client = new DefaultHttpClient(httpParams);
		    boolean result = true;
		    
	      try {
	         
	    	 
	         HttpResponse getResponse = client.execute(getRequest);	
	         
	         final int statusCode = getResponse.getStatusLine().getStatusCode();

	         
	         if (statusCode != HttpStatus.SC_OK) {
	            Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + WebServiceBaseUrl);
	            result = false;
	         }
	
	      }
	
	      catch (IOException e) {
	         getRequest.abort();
	         Log.w(getClass().getSimpleName(), "Error for URL " + WebServiceBaseUrl, e);
	         result = false;
	      }
	
	      return result;
	}
	
	   public String Get(String url) {
	       
	        HttpGet getRequest = new HttpGet(url);
	        
	      try {
	         
	    	 client = new DefaultHttpClient();
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
	    	  client = new DefaultHttpClient();
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
