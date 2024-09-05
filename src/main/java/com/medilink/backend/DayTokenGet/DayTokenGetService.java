package com.medilink.backend.DayTokenGet;

import com.medilink.backend.ModelDto.Data;
import com.medilink.backend.ModelDto.DayTokenGet;
import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DayTokenGetService {

      @Autowired
      DayTokenGetRepository dayTokenGetRepository;
      // Local istifade üçüb sadece Cod3 qaytarır
    public String dayTokenGetPrivate(String Cod1,String Cod2){
        List<?> tokenList= dayTokenGetRepository.dayTokenGet(Cod1,Cod2);
        DayTokenGet Cod3val =(DayTokenGet) code3ResponseMaping(tokenList).response.data.get(0);
        return Cod3val.Cod3;
    }
    // Controllerden gelen sorgu üçün Json qaytarır Calsslar vasitesi ile
    public MedilinkResponsTmp dayTokenGet(String Cod1,String Cod2){

        List<?> tokenList= dayTokenGetRepository.dayTokenGet(Cod1,Cod2);





        return  code3ResponseMaping(tokenList);
    }





    public MedilinkResponsTmp code3ResponseMaping(List<?> results){
        MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
        Data data = new Data();

            ArrayList<DayTokenGet> dayTokenGetResponses=new ArrayList<DayTokenGet>();
            List RsultList =List.of(results.get(0).toString().split("@",4));
            dayTokenGetResponses.add(new DayTokenGet(RsultList.get(2).toString()));

        medilinkResponsTmp.code =  RsultList.get(1).toString();
        medilinkResponsTmp.message =  RsultList.get(0).toString();
        medilinkResponsTmp.response = data;


        data.data= dayTokenGetResponses;



        return medilinkResponsTmp;


    }


}
