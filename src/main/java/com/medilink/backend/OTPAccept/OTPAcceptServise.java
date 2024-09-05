package com.medilink.backend.OTPAccept;

import com.medilink.backend.DayTokenGet.DayTokenGetService;
import com.medilink.backend.ModelDto.*;
import com.medilink.backend.OTPGenerator.OTPGeneratorServises;
import com.medilink.backend.SMSSend.SMSSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class OTPAcceptServise extends SMSSendService {

    @Autowired
    OTPAcceptRepository otpAcceptRepository;
    @Autowired
    OTPGeneratorServises otpGeneratorServises;
    @Autowired
    SMSSendService smsSendService;
    @Autowired
    DayTokenGetService dayTokenGetService;



    public MedilinkResponsTmp RegOTPMobile(Integer PId, String otp, String SentTo, Integer RId) throws ParseException {
        // front end tərəfə standart göndərilən classin tanımlanması
        MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
        Data data = new Data();
        //TOTP nin düzəltmək üçün cari tarix götürülür
         Long CurrentDateTimeLong = GetCurrentDatetime();
        //Otp düzəldilməsi üçün OTP generatora göndərilir
         String GeneratedTOTP=otpGeneratorServises.TOTPgenetator(CurrentDateTimeLong,180);
        //göndəriləcək OTP Db yə yazılır

        // List<?> otpSendingIbfToDB= otpAcceptRepository.RegOTPMobile(PId,GeneratedTOTP,SentTo,RId);

        List<?> otpSendingIbfToDB= otpAcceptRepository.RegOTPMobile(PId,"000000",SentTo,RId);
        //Qayıdan məlumat map edilir
          ArrayList<ResponsMessageMap> responsMessageMap= ResponsMessajMaping(otpSendingIbfToDB.get(0).toString());
        // qayıdan cavab hər hansı OTP nin dbyə yazılma İD-sisirsə ozaman SMS göndərilmə prosesi başlayır
        System.out.println(responsMessageMap.get(0).getMessageCode().toString());
        String MessageErrorCode=responsMessageMap.get(0).getMessageCode().toString();
        if (MessageErrorCode.equals(_AllConstants.VALUE_INTERNAL_OK.toString())){
            SMSResponse sMSResponse=smsSendService.smssend(GeneratedTOTP, SentTo);
            System.out.println(sMSResponse.getErrno());
            // SMS den gelen cavab DBye yazılır ve otp live vaxtı  qayıdır
            ArrayList<ResponsMessageMap> sMSResponseSend= new ArrayList<ResponsMessageMap>();
            sMSResponseSend= SendOtpMobile(Integer.parseInt(responsMessageMap.get(0).getMessageValue()), Integer.parseInt(sMSResponse.getErrno()),sMSResponse.getErrtext());
            medilinkResponsTmp.code= responsMessageMap.get(0).getMessageCode().toString();
            medilinkResponsTmp.message=responsMessageMap.get(0).getMessage().toString();
            medilinkResponsTmp.response=data;
               // Otpİd resulta əlavə edilir
            sMSResponseSend.get(0).setOtpId(responsMessageMap.get(0).getMessageValue());

            data.data= sMSResponseSend;

        } else{

            medilinkResponsTmp.code= responsMessageMap.get(0).getMessageCode().toString();
            medilinkResponsTmp.message=responsMessageMap.get(0).getMessage().toString();
            medilinkResponsTmp.response=data;
            data.data= responsMessageMap;

        }
        return medilinkResponsTmp;
    }

    public ArrayList<ResponsMessageMap> SendOtpMobile(Integer OtpId, Integer OtpSendStatus, String OtpSendResult){

        //SELECT `SendOtpMobile` (`OtpId` INT, `OtpSendStatus` INT, `OtpSendResult` VARCHAR(255));
        String Response=otpAcceptRepository.SendOtpMobile(OtpId,OtpSendStatus,OtpSendResult).get(0).toString();
        ArrayList<ResponsMessageMap> responsMessageMap= ResponsMessajMaping(Response);
        return  responsMessageMap;
   }


   public MedilinkResponsTmp CheckOtpMobile(String Otp, Integer  OtpId){
       ArrayList<ResponsMessageMap> responsMessageMap =new ArrayList<ResponsMessageMap>();
       MedilinkResponsTmp medilinkResponsTmp = new MedilinkResponsTmp();
       Data data = new Data();
       String Response=otpAcceptRepository.CheckOtpMobile(Otp,OtpId).get(0).toString();
       System.out.println(Response);
       responsMessageMap=ResponsMessajMaping(Response);
       medilinkResponsTmp.code= responsMessageMap.get(0).getMessageCode().toString();
       medilinkResponsTmp.message=responsMessageMap.get(0).getMessage().toString();
       medilinkResponsTmp.response=data;
       responsMessageMap.get(0).setOtpId(responsMessageMap.get(0).getMessageValue());
       data.data=responsMessageMap;
       return medilinkResponsTmp;
   }
    // Cari sistem tarix ve zamanını götürüb long-a çevirir
    public Long GetCurrentDatetime(){
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        Long date = zdt.toInstant().toEpochMilli();
        return date;
    }

    public ArrayList<ResponsMessageMap> ResponsMessajMaping(String ResponsMessage){
       ArrayList<ResponsMessageMap> responsMessageMap=new ArrayList<ResponsMessageMap>();
      System.out.println(ResponsMessage);

        List MessageMap= List.of(ResponsMessage.split("@"));

        switch(MessageMap.size()) {
            case 8:  responsMessageMap.add(new ResponsMessageMap(
                            MessageMap.get(0).toString(),
                            Integer.parseInt(MessageMap.get(1).toString()),
                            MessageMap.get(2).toString(),
                            MessageMap.get(3).toString(),
                            null,
                            MessageMap.get(4).toString(),
                            MessageMap.get(5).toString(),

                           // MessageMap.get(6).toString()
                           dayTokenGetService.dayTokenGetPrivate( MessageMap.get(4).toString(), MessageMap.get(5).toString()).toString()
                    )
            );
                break;
            case 7:  responsMessageMap.add(new ResponsMessageMap(
                            MessageMap.get(0).toString(),
                            Integer.parseInt(MessageMap.get(1).toString()),
                            MessageMap.get(2).toString(),
                            MessageMap.get(3).toString(),
                           null,
                            MessageMap.get(4).toString(),
                            MessageMap.get(5).toString(),
                            //MessageMap.get(6).toString()
                            dayTokenGetService.dayTokenGetPrivate(MessageMap.get(4).toString(), MessageMap.get(5).toString()).toString()
                    )
            );
                break;
            case 6:
                responsMessageMap.add(new ResponsMessageMap(
                                MessageMap.get(0).toString(),
                                Integer.parseInt(MessageMap.get(1).toString()),
                                MessageMap.get(2).toString(),
                                MessageMap.get(3).toString(),
                               null,
                                MessageMap.get(4).toString(),
                                MessageMap.get(5).toString(),
                        dayTokenGetService.dayTokenGetPrivate(MessageMap.get(4).toString(), MessageMap.get(5).toString())

                        )
                );
                break;
            case 5:
                responsMessageMap.add(new ResponsMessageMap(
                        MessageMap.get(0).toString(),
                        Integer.parseInt(MessageMap.get(1).toString()),
                        MessageMap.get(2).toString(),
                        MessageMap.get(3).toString(),
                        null,
                                MessageMap.get(4).toString(),
                        null,
                        null
                )
                );

                break;
            case 4:
                responsMessageMap.add(new ResponsMessageMap(
                        MessageMap.get(0).toString(),
                        Integer.parseInt(MessageMap.get(1).toString()),
                        MessageMap.get(2).toString(),
                        MessageMap.get(3).toString(),
                        null,
                        null,
                        null,
                        null));
                break;
            case 3:
                responsMessageMap.add(new ResponsMessageMap(MessageMap.get(0).toString(),
                        Integer.parseInt(MessageMap.get(1).toString()),
                        MessageMap.get(2).toString(), null,null, null,null,null));

                break;

            case 2:
                responsMessageMap.add(new ResponsMessageMap(MessageMap.get(0).toString(),
                        Integer.parseInt(MessageMap.get(1).toString()),
                        null, null, null, null,null,null));

            default:
                responsMessageMap.add(new ResponsMessageMap(MessageMap.get(0).toString(),
                        Integer.parseInt(MessageMap.get(1).toString()),
                        null, null, null, null,null,null));

        }


        return responsMessageMap;
    }

}
