package com.example.dowellmarketsketch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreenActivity extends Activity {
	private static final int SPLASH_TIME = 3000; // 3 secondes
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.splash);
	        try {
	        new Handler().postDelayed(new Runnable() {
	 
	            public void run() {
	                 
	                Intent intent = new Intent(SplashScreenActivity.this,
	                MainActivity.class);
	                startActivity(intent);	 
	                finish();	 
	               // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	            }
	             
	             
	        }, SPLASH_TIME);
	         
	        new Handler().postDelayed(new Runnable() {
	              public void run() {
	                     } 
	                }, SPLASH_TIME);
	        } catch(Exception e){}
	    }
	 
	     
	    @Override
	    public void onBackPressed() {
	        this.finish();
	        super.onBackPressed();
	    }
	
}
