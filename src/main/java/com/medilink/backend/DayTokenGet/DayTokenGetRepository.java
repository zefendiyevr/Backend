package com.medilink.backend.DayTokenGet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DayTokenGetRepository {


    @Autowired
    private EntityManager entityManager;

    public List<?> dayTokenGet(String Cod1, String Cod2) {



        Query q = (Query) entityManager.createNativeQuery("Select DailySessionId('" + Cod1 +"','"+ Cod2+ "')");

        System.out.println("Select DailySessionId('" + Cod1 +"','"+ Cod2+ "')");

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

}
