package com.medilink.backend.ModelDto;

public class SMSResponse {


    public String errno ;
    public String errtext;
    public String message_id;
    public String charge;

    public String balance;
    public void setErrno(String errno) {
        this.errno = errno;
    }

    public void setErrtext(String errtext) {
        this.errtext = errtext;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getErrno() {
        return errno;
    }

    public String getErrtext() {
        return errtext;
    }

    public String getMessage_id() {
        return message_id;
    }

    public String getCharge() {
        return charge;
    }

    public String getBalance() {
        return balance;
    }



}
