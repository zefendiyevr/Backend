package com.medilink.backend.SMSSend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SMSSend  {
    @Value("${sms.url}")
    private String smsurl;
    @Value("${sms.user}")
    private String smsuser;
    @Value( "${sms.pass}")
    private String  smspass;
    @Value("${sms.sendername}")
    private String  smssendername;
    private String MessageBoady;
    private String togsm;
    public String getTogsm() {
        return togsm;
    }
    public void setTogsm(String togsm) {
        this.togsm = togsm;
    }
    public String getMessageBoady() {
        return MessageBoady;
    }


    public void setMessageBoady(String messageBoady) {
        MessageBoady = messageBoady;
    }

    public String getSmsurl() {
        return smsurl;
    }

    public String getSmsuser() {
        return smsuser;
    }

    public String getSmspass() {
        return smspass;
    }

    public String getSmssendername() {
        return smssendername;
    }

    public String generateURL(){
       // http://api.msm.az/sendsms?user={Username}&password={Apikey}&gsm={NUMBER}&from={Sendername}&text={TEXT}
        String SMSCallUrl=smsurl+"?user="+smsuser+"&password="+smspass+"&gsm="+togsm+"&from="+smssendername+"&text="+MessageBoady;
        return SMSCallUrl;
    }


}
