package com.medilink.backend.HelpfulFunc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HelpfulFuncRepository {

    @Autowired
    EntityManager entityManager;
    public List<?> CheckPatientOrderNo(Integer HospId, Integer MemberId, String OrdNo) {
        Query q = (Query) entityManager.createNativeQuery("Select CheckPatientOrderNo('"+HospId+"','"+MemberId+"', '"+OrdNo+"') ");
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
