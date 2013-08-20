package com.example.dowellmarketsketch.model;
import com.google.gson.annotations.SerializedName;


public class WebServiceStandardResponse {
		@SerializedName("status")
	public int status;
	
	 @SerializedName("message")
	 public String message;
	 
	 @SerializedName("result")
	public String result;
	

	 public WebServiceStandardResponse(int status, String message, String result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}


	 public WebServiceStandardResponse() {
		super();
		this.status = -200;
		this.message = "Serveur indisponible";
	}



}
