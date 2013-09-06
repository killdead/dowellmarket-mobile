package com.dowellmarket.android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dowellmarket.android.R;
import com.dowellmarket.android.activity.BaseFragmentActivity;
import com.dowellmarket.android.activity.HomeActivity;
import com.dowellmarket.android.model.Model;
import com.dowellmarket.android.model.Settings;
import com.dowellmarket.android.model.User;

public class LoginActivity extends BaseFragmentActivity 
{//implements View.OnClickListener, View.OnKeyListener

	private EditText mLoginEditText;
	private EditText mPasswordEditText;
	private Button mSignUpButton;
	private Button mSignUpButton2;
	private Settings mSettings;

	public LoginActivity() {
		super(R.string.login);
		this.actionBarEnabled=false;
	}
	
	public void onCreate(Bundle paramBundle)
	  {
		super.onCreate(paramBundle, R.layout.activity_login);
		Log.i("Loginactivity", "Test loginactivity debug");
		Log.i("LoginActivity","ApiUrl = "+this.mApi.getBaseUrl());		
	    this.mSettings = Settings.getInstance();
	    this.mLoginEditText = ((EditText)findViewById(R.id.login));
	    this.mPasswordEditText = ((EditText)findViewById(R.id.password));
	    this.mSignUpButton = ((Button)findViewById(R.id.loginbutton));
	    this.mSignUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _signIn();
            }
        });
	    
	    this.mSignUpButton2 = ((Button)findViewById(R.id.loginbutton2));
	    this.mSignUpButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _signIn2();
            }
        });
	   
	   // this.mPasswordEditText.setOnKeyListener(this);
	   /* if (this.mSettings != null && !TextUtils.isEmpty(this.mSettings.getUserLogin()))
	      this.mLoginEditText.setText(this.mSettings.getUserLogin());*/
	  
	  }

	
	
	 
	 public void onClick(View paramView)
	  {
		 //_signIn(); 
	
	  }
	 
	 private void _signIn2() {
			boolean haserror = false;
			EditText localEditText = null;
			String str1 = this.mLoginEditText.getText().toString();
			String str2 = this.mPasswordEditText.getText().toString();
			/*if (TextUtils.isEmpty(str1)) {
				haserror = true;
				localEditText = this.mLoginEditText;
				this.mLoginEditText.setError(this.mRes.getString(R.string.error_empty_field));
			}
			if (str1.length() < 6 && !haserror) {
				haserror = true;
				localEditText = this.mLoginEditText;
				this.mLoginEditText.setError(this.mRes.getString(R.string.error_login_length));
			}
			
			if ((str2.length() < 6) || (str2.length() > 128) && !haserror) {
				haserror = true;
				localEditText = this.mPasswordEditText;
				this.mPasswordEditText.setError(this.mRes.getString(R.string.error_password_length));
			}*/
			haserror = false;
			str1="user02";
			str2="user02user02";
			if (haserror) 
				localEditText.requestFocus();
			else {
				
				  User localUser = new User(); 
				  localUser.setLogin(str1);
				  localUser.setPassword(str2); 
				  localUser.method="auth.gettoken";
				  
				  Log.i("ApiLogin",localUser.toString());
				  this.mApi.postSession(localUser);
				 
			
			}
		}
	
	
	private void _signIn() {
		boolean haserror = false;
		EditText localEditText = null;
		String str1 = this.mLoginEditText.getText().toString();
		String str2 = this.mPasswordEditText.getText().toString();
		/*if (TextUtils.isEmpty(str1)) {
			haserror = true;
			localEditText = this.mLoginEditText;
			this.mLoginEditText.setError(this.mRes.getString(R.string.error_empty_field));
		}
		if (str1.length() < 6 && !haserror) {
			haserror = true;
			localEditText = this.mLoginEditText;
			this.mLoginEditText.setError(this.mRes.getString(R.string.error_login_length));
		}
		
		if ((str2.length() < 6) || (str2.length() > 128) && !haserror) {
			haserror = true;
			localEditText = this.mPasswordEditText;
			this.mPasswordEditText.setError(this.mRes.getString(R.string.error_password_length));
		}*/
		haserror = false;
		str1="user01";
		str2="user01user01";
		if (haserror) 
			localEditText.requestFocus();
		else {
			
			  User localUser = new User(); 
			  localUser.setLogin(str1);
			  localUser.setPassword(str2); 
			  localUser.method="auth.gettoken";
			  
			  Log.i("ApiLogin",localUser.toString());
			  this.mApi.postSession(localUser);
			 
		
		}
	}
	 public void onApiRequestSuccess(int paramInt1, int httpError, String paramString)
	  {
		 showProgress(false);
		 Model.StandardResponse localResponse = Model.getStandardResponse(paramString);
	     
		switch (localResponse.status) {
		case 0:
			String str = "{\"userAuthToken\":" + localResponse.result + "}";
			this.mSettings.setUserAuthToken(str);

			this.mIntent = new Intent(this.mContext, HomeActivity.class);
			// this.mIntent.putExtra("user", paramString);
			this.mContext.startActivity(this.mIntent);
			this.mApi.setUserAuthToken(localResponse.result);
			setResult(-1);
			finish();
			break;
		case -1:
		default:
			Toast.makeText(this.mContext, localResponse.message,
					Toast.LENGTH_LONG).show();
		}
		
		    
	  }

	


	
}