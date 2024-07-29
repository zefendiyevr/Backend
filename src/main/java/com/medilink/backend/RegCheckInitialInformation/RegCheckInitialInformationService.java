package com.medilink.backend.RegCheckInitialInformation;

import com.medilink.backend.ModelDto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RegCheckInitialInformationService {
@Autowired
private RegCheckInitialInformationRepository regCheckInitialInformationRepository;

public MedilinkResponsTmp RegisterStepOne(String  RegTime, String  IpAdd, Integer DevId, Integer HospId, String ReferralVal, String FinCode, Integer OrdNo){
    List xx= regCheckInitialInformationRepository.RegisterStepOne(RegTime,   IpAdd,  DevId,  HospId,  ReferralVal,  FinCode, OrdNo);
    String result =xx.get(0).toString()+" @ 0";
    List aa= List.of(result.split("@", 100));
    MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
    Data data = new Data();
    medilinkResponsTmp.code = "200";
    medilinkResponsTmp.message = "Successuful!";
    medilinkResponsTmp.response = data;
    ArrayList<RegisterStepOneResponse> registerStepOneResponses = new ArrayList<>();
    registerStepOneResponses.add(new RegisterStepOneResponse(aa.get(0).toString(),aa.get(1).toString(),aa.get(2).toString() ));
    medilinkResponsTmp.code = aa.get(1).toString();
    medilinkResponsTmp.message = aa.get(0).toString();

    data.data = registerStepOneResponses;
    System.out.println(medilinkResponsTmp);
    return medilinkResponsTmp;

}

    public MedilinkResponsTmp RegisterStepTowGet(Integer PId, Integer Rid) {
        List listTowGet = regCheckInitialInformationRepository.RegisterStepTwoGet(PId, Rid);
        return RegisterStepTwoMaping(listTowGet);
    }


    public MedilinkResponsTmp RegisterStepTowAccept(Integer PId, Integer Rid ){

        List listTowGet= regCheckInitialInformationRepository.RegisterStepTwoAccept(PId,Rid);

        return  RegisterStepTwoAcceptMaping(listTowGet);
    }

    public MedilinkResponsTmp RegisterStepTwoMaping(List<?> results){
   // ArrayList<RegisterStepTwoGetResponse> registerStepTwoGetResponses=new ArrayList<RegisterStepTwoGetResponse>();
        MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
        Data data = new Data();
        medilinkResponsTmp.code = "200";
        medilinkResponsTmp.message = "Successuful!";
        medilinkResponsTmp.response = data;
        ArrayList<ReturnValueResponse> returnValueResponse = new ArrayList<>();
        ArrayList<RegisterStepTwoGetResponse> registerStepTwoGetResponses = new ArrayList<>();
        try {
                Object[] objArr = (Object[]) results.get(0);

                for(int i=0; i<results.size(); i++){
                    objArr = (Object[]) results.get(i);
                    registerStepTwoGetResponses.add(new RegisterStepTwoGetResponse(
                        (String) Arrays.stream(objArr).toList().get(0),
                        (String) Arrays.stream(objArr).toList().get(1),
                        (String) Arrays.stream(objArr).toList().get(2),
                        (String) Arrays.stream(objArr).toList().get(3).toString(),
                        (String) Arrays.stream(objArr).toList().get(4),
                        (String) Arrays.stream(objArr).toList().get(5)
                    ));
                    data.data = registerStepTwoGetResponses;
                }
            } catch (Exception e){

                String result =results.get(0).toString();
                List aa= List.of(result.split("@", 4));

                medilinkResponsTmp.message = aa.get(0).toString();
                medilinkResponsTmp.code = aa.get(1).toString();
                returnValueResponse.add(new ReturnValueResponse(aa.get(2).toString()));
                data.data = returnValueResponse;
            }


        return medilinkResponsTmp;


    }

    public MedilinkResponsTmp RegisterStepTwoAcceptMaping(List<?> results){
        // ArrayList<RegisterStepTwoGetResponse> registerStepTwoGetResponses=new ArrayList<RegisterStepTwoGetResponse>();
        MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
        Data data = new Data();
        medilinkResponsTmp.code = "200";
        medilinkResponsTmp.message = "Successuful!";
        medilinkResponsTmp.response = data;
        ArrayList<ReturnValueResponse> returnValueResponse = new ArrayList<>();
        ArrayList<RegisterStepTwoGetResponse> registerStepTwoGetResponses = new ArrayList<>();
        String a=results.get(0).toString();






            String result =results.get(0).toString();
            List aa= List.of(result.split("@", 4));

            medilinkResponsTmp.message = aa.get(0).toString();
            medilinkResponsTmp.code = aa.get(1).toString();
            returnValueResponse.add(new ReturnValueResponse(aa.get(2).toString()));
            data.data = returnValueResponse;



        return medilinkResponsTmp;


    }

}
