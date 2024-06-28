package com.sharp.dto;

import com.sharp.model.PropertyInfo;

public class PvInsertResponse {
	
	
	private int statusCode;
    private String message;
    private PropertyInfo data;
    private String error;
    
    
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PropertyInfo getData() {
		return data;
	}
	public void setData(PropertyInfo data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}

}
