package com.medilink.backend.CheckConnection;

import com.medilink.backend.ModelDto.CheckConnectionRespons;
import com.medilink.backend.ModelDto.Data;
import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CheckConnectionService {

    public MedilinkResponsTmp CheckConnectionAnswer(){
         MedilinkResponsTmp medilinkResponsTmp=new MedilinkResponsTmp();
         Data data=new Data();
         ArrayList<CheckConnectionRespons> checkConnectionRespons=new ArrayList<CheckConnectionRespons>();
         checkConnectionRespons.add(new CheckConnectionRespons(1));
         medilinkResponsTmp.code="200";
         medilinkResponsTmp.message="Connection is successful!";
         medilinkResponsTmp.response=data;
         data.data=checkConnectionRespons;
         return medilinkResponsTmp;
    }
}
