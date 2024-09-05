package com.medilink.backend.HospitalList;

import com.medilink.backend.ModelDto.Data;
import com.medilink.backend.ModelDto.HospitalListResponse;
import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HospitalListService {


    @Autowired
    public HospitalListRepository hospitalListRepository;

    public MedilinkResponsTmp HospitalList(String Lang) {
        MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
        Data data = new Data();
        medilinkResponsTmp.code =  "200";
        medilinkResponsTmp.message =  "Successuful!";
        medilinkResponsTmp.response = data;
        data.data = HospitalListMaping(hospitalListRepository.GetHospitalList(Lang));
        return medilinkResponsTmp;
    }

    public ArrayList<HospitalListResponse> HospitalListMaping(List<?> results){
        ArrayList<HospitalListResponse> hospitalListResponses=new ArrayList<HospitalListResponse>();
        for(int i=0; i<results.size(); i++) {
            Object[] objArr = (Object[]) results.get(i);
            hospitalListResponses.add(new HospitalListResponse((Integer) Arrays.stream(objArr).toList().get(0), (String) Arrays.stream(objArr).toList().get(1)));

        }

         return hospitalListResponses;


    }



}
