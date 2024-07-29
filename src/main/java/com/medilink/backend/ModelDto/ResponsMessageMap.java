package com.medilink.backend.ModelDto;

public class ResponsMessageMap {

    String Message;
    Integer MessageCode;
    String MessageValue;
    String MessageHeader;
    String OtpId;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Integer getMessageCode() {
        return MessageCode;
    }

    public void setMessageCode(Integer messageCode) {
        MessageCode = messageCode;
    }

    public String getMessageValue() {
        return MessageValue;
    }

    public void setMessageValue(String messageValue) {
        MessageValue = messageValue;
    }

    public String getMessageHeader() {
        return MessageHeader;
    }

    public void setMessageHeader(String messageHeader) {
        MessageHeader = messageHeader;
    }

    public String getOtpId() {
        return OtpId;
    }

    public void setOtpId(String otpId) {
        OtpId = otpId;
    }




    public ResponsMessageMap(String message, Integer messageCode, String messageValue, String messageHeader, String otpId) {
        Message = message;
        MessageCode = messageCode;
        MessageValue = messageValue;
        MessageHeader = messageHeader;
        OtpId = otpId;
    }




}
