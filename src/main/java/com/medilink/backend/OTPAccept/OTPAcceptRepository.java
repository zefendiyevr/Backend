package com.medilink.backend.OTPAccept;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OTPAcceptRepository {

    @Autowired
    private EntityManager entityManager;
    public List<?> RegOTPMobile(Integer  PId, String Otp, String SentTo, Integer RId) {

        String QueryText="Select RegOTPMobile('"+PId+"','"+Otp+"','"+SentTo+"','"+RId+"')";

        Query q = (Query) entityManager.createNativeQuery(QueryText);

        try {
            List<?> results= new ArrayList<>();
            results = q.getResultList();
            return results;
        } catch (Exception e){
            List<String> results1= new ArrayList<>();
            results1.add("Internal Error!@00@Error");
            return results1;
        }


    }

    public List<?> SendOtpMobile(Integer  OtpId, Integer OtpStatus, String OtpSendResult) {

        //SELECT `SendOtpMobile` (`OtpId` INT, `OtpSendStatus` INT, `OtpSendResult` VARCHAR(255));
        Query q = (Query) entityManager.createNativeQuery("Select SendOtpMobile('"+OtpId+"','"+OtpStatus+"','"+OtpSendResult+"')");
        try {
            List<?> results= new ArrayList<>();
            results = q.getResultList();
            return results;
        } catch (Exception e){
            List<String> results1= new ArrayList<>();
            results1.add("Internal Error!@00@SQLError");
            return results1;
        }

    }


    public List<?> CheckOtpMobile(String Otp, Integer  OtpId) {
        //SELECT `CheckOtpMobile` (`Otp` VARCHAR(6), `OtpId` INT);
        Query q = (Query) entityManager.createNativeQuery("Select CheckOtpMobile('"+Otp+"','"+OtpId+"')");
        try {
            List<?> results= new ArrayList<>();
            results = q.getResultList();
            return results;
        } catch (Exception e){
            List<String> results1= new ArrayList<>();
            results1.add("Internal Error!@00@SQLError");
            return results1;
        }
    }

}
