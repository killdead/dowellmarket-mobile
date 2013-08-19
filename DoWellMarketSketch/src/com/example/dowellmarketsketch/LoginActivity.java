package com.example.dowellmarketsketch;

import com.example.dowellmarketsketch.model.WebServiceStandardResponse;
import com.example.dowellmarketsketch.webservice.UserWebService;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	public static final String PREFS_NAME = "LoginPrefs";
	EditText username;
	EditText password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        /*
         * Check if we successfully logged in before. 
         * If we did, redirect to home page
         */
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		if (settings.getString("logged", "").toString().equals("logged")) {
			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(intent);
		}
		
        Button b = (Button) findViewById(R.id.loginbutton);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				username = (EditText) findViewById(R.id.login);
				password = (EditText) findViewById(R.id.password);
				
				if(username.getText().toString().length() > 0 && password.getText().toString().length() > 0 ) {
					doLogin();
					/*if(username.getText().toString().equals("test") && password.getText().toString().equals("test")) {
						
						SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
						SharedPreferences.Editor editor = settings.edit();
						editor.putString("logged", "logged");
						editor.commit();

						Intent intent = new Intent(Login.this, MainActivity.class);
						startActivity(intent);
					}*/
				}
			}
		});
    }


    public void doLogin() {
		new AsyncTask<Void, Void, WebServiceStandardResponse>() {
			
			final ProgressDialog dialog = new ProgressDialog(LoginActivity.this);
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

				WebServiceStandardResponse response = webService.Connect(username.getText().toString(), password.getText().toString());

				if (response != null) {
					return response;
				}

				return new WebServiceStandardResponse();
			}

			protected void onPostExecute(WebServiceStandardResponse result) {
             
				if(result.status==0) {
					 
					//dialog.setMessage("Connexion OK, token= : "+result.result);
				dialog.dismiss();
					 
				Toast.makeText(LoginActivity.this,"Connexion OK, token : "+ result.result,  Toast.LENGTH_LONG).show();
				
				SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
				SharedPreferences.Editor editor = settings.edit();
				editor.putString("logged", "logged");
				editor.commit();

				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);
				
				finish();
				}
				else {
					 
					//dialog.setMessage("Erreur de connexion : "+result.message);
					Toast.makeText(LoginActivity.this, result.message,  Toast.LENGTH_LONG).show();
					
					dialog.dismiss();
				}
				
					
				}
				
			}.execute();

		}

}