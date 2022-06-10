package com.db.naceloader.model;

public class ResponseUserMessage {
    private String message;

    public ResponseUserMessage(){}

    public ResponseUserMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
