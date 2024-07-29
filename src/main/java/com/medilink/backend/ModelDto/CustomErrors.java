package com.medilink.backend.ModelDto;

public class CustomErrors {
    String Timestamp;
    Integer Errorcode;
    String Message;
    public CustomErrors(String timestamp, Integer errorcode, String message) {
        Timestamp = timestamp;
        Errorcode = errorcode;
        Message = message;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Integer getErrorcode() {
        return Errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        Errorcode = errorcode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
