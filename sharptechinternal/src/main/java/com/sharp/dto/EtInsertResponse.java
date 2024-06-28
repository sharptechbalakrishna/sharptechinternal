package com.sharp.dto;

import com.sharp.model.EtGeneralInfo;

public class EtInsertResponse {
    private int statusCode;
    private String message;
    private EtGeneralInfo data;
    private String error;

    // Getters and Setters
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

    public EtGeneralInfo getData() {
        return data;
    }

    public void setData(EtGeneralInfo data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
