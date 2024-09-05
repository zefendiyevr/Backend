package com.medilink.backend.RegCheckInitialInformation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RegCheckInitialInformationRepository {

    @Autowired
    private EntityManager entityManager;
    public List<?> RegisterStepOne(String  RegTime, String  IpAdd, Integer DevId, Integer HospId, String ReferralVal, String FinCode, Integer OrdNo) {
        Query q = (Query) entityManager.createNativeQuery("select RegisterStepOne('" + RegTime +"','"+ IpAdd+"','"+DevId +"','"+ HospId+"','"+ReferralVal+"','"+FinCode +"','"+OrdNo+ "')");
        //  List<RegisterStepOneResponse> results = q.getResultList();
        System.out.println("select RegisterStepOne('" + RegTime +"','"+ IpAdd+"','"+DevId +"','"+ HospId+"','"+ReferralVal+"','"+FinCode +"','"+OrdNo+ "')");
         // Buraya yeniden Try{} yazılacaq

        try {
            List<?> results= new ArrayList<>();
            results = q.getResultList();
            return results;
        } catch (Exception e){
            List<String> results1= new ArrayList<>();
            results1.add("Internal Error!@000@SQLError@0@0@0");
            return results1;
        }
    }

    public List<?> RegisterStepTwoGet(Integer PId, Integer RId) {

        System.out.println("call RegisterStepTwoGet('" + PId +"','"+ RId+ "')");

        Query q = (Query) entityManager.createNativeQuery("call RegisterStepTwoGet('" + PId +"','"+ RId+ "')");

       try {
           List<?> results= new ArrayList<>();
            results = q.getResultList();
           return results;
       } catch (Exception e){
           List<String> results1= new ArrayList<>();
            results1.add("Internal Error!@000@SQLError");
           return results1;
       }



    }

    public List<?> RegisterStepTwoAccept(Integer PId, Integer RId) {
        Query q = (Query) entityManager.createNativeQuery("call RegisterStepTwoAccept('" + PId +"','"+ RId+ "')");

        try {
            List<?> results= new ArrayList<>();
            results = q.getResultList();
            return results;
        } catch (Exception e){
            List<String> results1= new ArrayList<>();
            results1.add("Internal Error!@00@SQLError@Pid");
            return results1;
        }



    }

}



