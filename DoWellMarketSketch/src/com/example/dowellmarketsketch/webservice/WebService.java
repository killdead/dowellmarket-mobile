package com.example.dowellmarketsketch.webservice;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.google.gson.Gson;
public abstract class WebService {

	
    protected Gson gson;
    public static final String WebServiceBaseUrl = "http://dev.dowellmarket.com";
  //  public static final String WebServiceBaseUrl = "http://192.168.0.12/elgg";
    public static final boolean DistantSite  = true;
    private static DefaultHttpClient client = new DefaultHttpClient(); 
    

	public WebService() {
		gson = new Gson();
	}
	
	boolean isAvailable()
	{
		 final HttpGet getRequest = new HttpGet(WebServiceBaseUrl);
		 final HttpParams httpParams = new BasicHttpParams();
		 HttpConnectionParams.setConnectionTimeout(httpParams, 2000);
		    
		client = new DefaultHttpClient(httpParams);
		 if(DistantSite) {
			 client.getCredentialsProvider().setCredentials(new AuthScope(null, -1),
					 new UsernamePasswordCredentials("admin","iverson"));

		 }
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
	
	
	   String GetService(String url) {
	       
	        HttpGet getRequest = new HttpGet(WebServiceBaseUrl+url);
	        
	      try {
	         
	    //	 client = new DefaultHttpClient();
	    	  if(DistantSite) {
	    		  client.getCredentialsProvider().setCredentials(new AuthScope(null, -1),
	 					 new UsernamePasswordCredentials("admin","iverson"));

	 		 }
	    	  
	    	  
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
	   

	   String PostService(String url,List<NameValuePair> params) {
	       
	        HttpPost getRequest = new HttpPost(WebServiceBaseUrl+url);
	        
	        
	      try {
	         
	    	  getRequest.setEntity(new UrlEncodedFormEntity(params));
	    	   
	    	  if(DistantSite) {
	    		  client.getCredentialsProvider().setCredentials(new AuthScope(null, -1),
	 					 new UsernamePasswordCredentials("admin","iverson"));

	 		 }
	    	  
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
