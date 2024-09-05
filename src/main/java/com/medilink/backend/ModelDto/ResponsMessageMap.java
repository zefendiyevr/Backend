package com.medilink.backend.ModelDto;

public class ResponsMessageMap {

    String Message;
    Integer MessageCode;
    String MessageValue;
    String MessageHeader;
    String OtpId;
    String Code1;
    String Code2;
    String Code3;
    public String getCode1() {
        return Code1;
    }

    public void setCode1(String code1) {
        Code1 = code1;
    }

    public String getCode2() {
        return Code2;
    }

    public void setCode2(String code2) {
        Code2 = code2;
    }

    public String getCode3() {
        return Code3;
    }

    public void setCode3(String code3) {
        Code3 = code3;
    }





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




    public ResponsMessageMap(String message, Integer messageCode, String messageValue, String messageHeader, String otpId,String code1,
    String code2,
    String code3) {
        Message = message;
        MessageCode = messageCode;
        MessageValue = messageValue;
        MessageHeader = messageHeader;
        OtpId = otpId;
        Code1=code1;
        Code2=code2;
        Code3=code3;

    }




}
