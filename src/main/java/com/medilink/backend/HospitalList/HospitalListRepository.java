package com.medilink.backend.HospitalList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HospitalListRepository {

    @Autowired
    private EntityManager entityManager;
    public List<?> getHospitalList(String Lang) {
        Query q = (Query) entityManager.createNativeQuery("CALL ListofHospital() ");
        List<?> results = q.getResultList();
        return results;
    }




}
