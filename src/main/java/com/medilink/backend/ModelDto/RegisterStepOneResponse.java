package com.medilink.backend.ModelDto;

public class RegisterStepOneResponse {




    public String Message;



    public String Code;

    public String Value;

    public String PId;
    public RegisterStepOneResponse(String message, String code, String value,String pid ) {
        Message = message;
        Code = code;
        Value=value;
        PId=pid;

    }

}
