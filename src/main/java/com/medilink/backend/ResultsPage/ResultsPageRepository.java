package com.medilink.backend.ResultsPage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ResultsPageRepository {

    @Autowired
    EntityManager entityManager;
    public List<?> listofNewReports(String Cod1, String  Cod2, String Cod3) {

        Query q = (Query) entityManager.createNativeQuery("call ListofNewReports('"+Cod1+"','"+Cod2+"','"+Cod3+"')");

        System.out.println("call ListofNewReports('"+Cod1+"','"+Cod2+"','"+Cod3+"')");
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
