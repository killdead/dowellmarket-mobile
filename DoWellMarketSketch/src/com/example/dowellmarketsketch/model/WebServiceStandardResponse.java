package com.example.dowellmarketsketch.model;
import com.google.gson.annotations.SerializedName;


public class WebServiceStandardResponse {
	 @SerializedName("status")
	public int status;
	
	 @SerializedName("message")
	 public String message;
	 
	 @SerializedName("result")
	public String result;
	

}
