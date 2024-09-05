package com.medilink.backend.RegisterDevice;

import com.medilink.backend.ModelDto.CheckConnectionRespons;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Query(value="select RegisterDevice(?1,?2)", nativeQuery = true)
//  public Integer RegisterDevice(String DeviceName, String DeviceUid);

@Repository
public  class RegisterDeviceRepository  {

   @Autowired
   private EntityManager entityManager;
   public List<?> getAllResult(String DeviceName, String DeviceOid, String Lang) {

       Query q = (Query) entityManager.createNativeQuery("select RegisterDevice('" + DeviceName + "','" + DeviceOid + "')");
       List<CheckConnectionRespons> results = q.getResultList();
       return results;
    }

}