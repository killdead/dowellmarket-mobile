package com.example.dowellmarketsketch;

import com.example.dowellmarketsketch.model.WebServiceStandardResponse;
import com.example.dowellmarketsketch.webservice.UserWebService;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	public static final String PREFS_NAME = "LoginPrefs";
	EditText loginEditText;
	EditText passwordEditText;
	// Values for login and password at the time of the login attempt.
    private String mLogin;
    private String mPassword;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        /*
         * Check if we successfully logged in before. 
         * If we did, redirect to home page
         */
    /*    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		if (settings.getString("logged", "").toString().equals("logged")) {
			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
			startActivity(intent);
		}*/
		
        Button b = (Button) findViewById(R.id.loginbutton);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AttemptLogin() ;
				}
			
		});
    }
    
    public void AttemptLogin() {
    	loginEditText = (EditText) findViewById(R.id.login);
		passwordEditText = (EditText) findViewById(R.id.password);
		
		loginEditText.setError(null);
		passwordEditText.setError(null);
		mLogin = loginEditText.getText().toString();
		mPassword = passwordEditText.getText().toString();
		
		 boolean cancel = false;
	        View focusView = null;

	        // Check for a valid password.
	        if (TextUtils.isEmpty(mPassword)) {
	            passwordEditText.setError(getString(R.string.error_field_required));
	            focusView = passwordEditText;
	            cancel = true;
	        } else if (mPassword.length() < 4) {
	        	passwordEditText.setError(getString(R.string.error_invalid_password));
	            focusView = passwordEditText;
	            cancel = true;
	        }

	        // Check for a valid email address.
	        if (TextUtils.isEmpty(mLogin)) {
	        	loginEditText.setError(getString(R.string.error_field_required));
	            focusView = loginEditText;
	            cancel = true;
	        } 

	        if (cancel) {
	            // There was an error; don't attempt login and focus the first
	            // form field with an error.
	            focusView.requestFocus();
	        } else {	
	        	
	        	doWebServiceLogin();
			
			}
    }


    public void doWebServiceLogin() {
		new AsyncTask<Void, Void, WebServiceStandardResponse>() {
			
			final ProgressDialog dialog = new ProgressDialog(LoginActivity.this);
	    	//Context mcontext;
	    	
			
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				dialog.setMessage(getString(R.string.login_progress_signing_in));
			    dialog.show();
			}

			@Override
			protected WebServiceStandardResponse doInBackground(Void... params) {
				UserWebService webService = new UserWebService();

				WebServiceStandardResponse response = webService.Connect(mLogin, mPassword);

				if (response != null) {
					return response;
				}

				return new WebServiceStandardResponse();
			}

			protected void onPostExecute(WebServiceStandardResponse result) {
             
				if(result.status==0) {
					 
					
				dialog.dismiss();
					
				SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
				SharedPreferences.Editor editor = settings.edit();
				editor.putString("logged", "logged");
				editor.commit();
				finish();
				
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				//intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				
				
				}
				
				else if(result.status == -200) {
					//dialog.setMessage("Erreur de connexion : "+result.message);
					Toast.makeText(LoginActivity.this, result.message,  Toast.LENGTH_LONG).show();
					dialog.dismiss();
					
				}
				else {
					 
					//dialog.setMessage("Erreur de connexion : "+result.message);
					Toast.makeText(LoginActivity.this, result.message,  Toast.LENGTH_LONG).show();
					passwordEditText.setError(getString(R.string.error_incorrect_password));
					passwordEditText.requestFocus();
					dialog.dismiss();
				}
				
					
				}
				
			}.execute();

		}

}