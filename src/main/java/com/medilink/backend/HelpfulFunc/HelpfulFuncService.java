package com.medilink.backend.HelpfulFunc;

import com.medilink.backend.ModelDto.Data;
import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import com.medilink.backend.ModelDto.ReturnValueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelpfulFuncService {
      @Autowired
      HelpfulFuncRepository helpfulFuncRepository;
    public MedilinkResponsTmp CheckPatientOrderNo(Integer HospId, Integer MemberId, String OrdNo ) {

        MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
        Data data = new Data();
        medilinkResponsTmp.code =  "200";
        medilinkResponsTmp.message =  "Successuful!";
        medilinkResponsTmp.response = data;
        ArrayList<ReturnValueResponse> returnValueResponse=new ArrayList<ReturnValueResponse>();

        List<?> ValueList= helpfulFuncRepository.CheckPatientOrderNo(HospId,MemberId,OrdNo);


      //  ValueList.get(0).toString().length()>4)






        data.data =returnValueResponse;



        return medilinkResponsTmp;

    }

}
