package com.medilink.backend.RegCheckInitialInformation;

import com.medilink.backend.ModelDto.*;
import com.medilink.backend.OTPAccept.OTPAcceptServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RegCheckInitialInformationService {
@Autowired
private RegCheckInitialInformationRepository regCheckInitialInformationRepository;
@Autowired
private OTPAcceptServise otpAcceptServise;
    public MedilinkResponsTmp RegisterStepOne(String  RegTime, String  IpAdd, Integer DevId, Integer HospId, String ReferralVal, String FinCode, Integer OrdNo){
    List xx= regCheckInitialInformationRepository.RegisterStepOne(RegTime,   IpAdd,  DevId,  HospId,  ReferralVal,  FinCode, OrdNo);


    String result =xx.get(0).toString()+" @ 0";
    List aa= List.of(result.split("@", 100));

    System.out.println(result);

    MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();


    Data data = new Data();


    medilinkResponsTmp.code = "200";
    medilinkResponsTmp.message = "Successuful!";
    medilinkResponsTmp.response = data;
    ArrayList<RegisterStepOneResponse> registerStepOneResponses = new ArrayList<>();
     System.out.println(aa.get(1).toString());
    if (aa.get(1).toString().equals(_AllConstants.VALUE_INTERNAL_OK.toString())){

   return  registerStepTowGet(Integer.parseInt(aa.get(4).toString().trim()),Integer.parseInt( aa.get(2).toString().trim()));
    } else {


        registerStepOneResponses.add(new RegisterStepOneResponse(aa.get(0).toString(), aa.get(1).toString(), aa.get(2).toString(), aa.get(4).toString()));
        medilinkResponsTmp.code = aa.get(1).toString();
        medilinkResponsTmp.message = aa.get(0).toString();

        data.data = registerStepOneResponses;
        System.out.println(medilinkResponsTmp);
        return medilinkResponsTmp;
    }
}

    public MedilinkResponsTmp registerStepTowGet(Integer PId, Integer Rid) {
        List listTowGet = regCheckInitialInformationRepository.RegisterStepTwoGet(PId, Rid);


        return RegisterStepTwoMaping(listTowGet,PId,Rid);
    }


    public MedilinkResponsTmp RegisterStepTowAccept(Integer PId, Integer Rid, String PhoneNumber  ){
      PhoneNumber = GetphoneNumberFromGetInfoList(regCheckInitialInformationRepository.RegisterStepTwoGet(PId, Rid));
      List listTowGet= regCheckInitialInformationRepository.RegisterStepTwoAccept(PId,Rid);
      return  RegisterStepTwoAcceptMaping(listTowGet, PId, Rid, PhoneNumber);
    }


    public String GetphoneNumberFromGetInfoList(List<?> results){
        Object[] objArr = (Object[]) results.get(0);
        String PhoneNumber="";
        for(int i=0; i<results.size(); i++) {
            objArr = (Object[]) results.get(i);

             PhoneNumber=Arrays.stream(objArr).toList().get(4).toString();



        }
        return PhoneNumber;
    }

    public MedilinkResponsTmp RegisterStepTwoMaping(List<?> results, Integer PId, Integer Rid){
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
            System.out.println(results.get(0));
                for(int i=0; i<results.size(); i++){
                    objArr = (Object[]) results.get(i);
                    registerStepTwoGetResponses.add(new RegisterStepTwoGetResponse(
                            (String) Arrays.stream(objArr).toList().get(1)+" "+Arrays.stream(objArr).toList().get(0)+" "+Arrays.stream(objArr).toList().get(2),
                        (String) Arrays.stream(objArr).toList().get(0),
                        (String) Arrays.stream(objArr).toList().get(1),
                        (String) Arrays.stream(objArr).toList().get(2),
                        (String) Arrays.stream(objArr).toList().get(3).toString(),
                        (String) Arrays.stream(objArr).toList().get(4),
                        (String) Arrays.stream(objArr).toList().get(5),
                        PId.toString(),
                        Rid.toString()
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

    public MedilinkResponsTmp RegisterStepTwoAcceptMaping(List<?> results, Integer Pid, Integer Rid, String PhoneNumber){
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


        if (aa.get(1).toString().equals(_AllConstants.VALUE_INTERNAL_OK.toString())){
            try {
                    return otpAcceptServise.RegOTPMobile(Pid, "11111", PhoneNumber, Rid);
            } catch (Exception e) {
                System.out.println("OTP Prosedurda problem yarandı");

                medilinkResponsTmp.message = aa.get(0).toString();
                medilinkResponsTmp.code = aa.get(1).toString();
                returnValueResponse.add(new ReturnValueResponse(aa.get(2).toString()));
                data.data = returnValueResponse;

                return medilinkResponsTmp;
            }
        } else {


            medilinkResponsTmp.message = aa.get(0).toString();
            medilinkResponsTmp.code = aa.get(1).toString();
            returnValueResponse.add(new ReturnValueResponse(aa.get(2).toString()));
            data.data = returnValueResponse;

            return medilinkResponsTmp;

        }




    }

}
