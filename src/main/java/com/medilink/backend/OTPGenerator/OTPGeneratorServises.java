package com.medilink.backend.OTPGenerator;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.medilink.backend.OTPGenerator.TOTP.generateTOTP;
@Service
public class OTPGeneratorServises {

    DateTimeOperation dateTimeOperation =new DateTimeOperation();



   public Date StringToDAtetime(String DateTime) throws ParseException {
       dateTimeOperation.DadetimeString=DateTime;
       return dateTimeOperation.StringToDatetime();
   }

    public Long DatetimeToLong(String DateTime) throws ParseException {

        dateTimeOperation.DadetimeString=DateTime;

        Long LongDatatime=dateTimeOperation.DatetimeToLong();
        System.out.println("DateTimeString------->DatetimeLong");

        return LongDatatime;
    }

   public String TOTPgenetator(long TimeNumber, long Xtime )
   {

       String seed64 = "3132333435363738393031323334353637383930" +
               "3132333435363738393031323334353637383930" +
               "3132333435363738393031323334353637383930" +
               "31323334";
       long T0 = 0;
       long X = Xtime;
       long testTime[] = {TimeNumber};

       String steps = "0";
       String OTPKey="";
       DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       df.setTimeZone(TimeZone.getTimeZone("UTC"));


       try {
           System.out.println(
                   "+---------------+-----------------------+" +
                           "------------------+--------+--------+");
           System.out.println(
                   "|  Time(sec)    |   Time (UTC format)   " +
                           "| Value of T(Hex)  |  TOTP  | Mode   |");
           System.out.println(
                   "+---------------+-----------------------+" +
                           "------------------+--------+--------+");





           for (int i=0; i<testTime.length; i++) {
               long T = (testTime[i] - T0)/X;
               steps = Long.toHexString(T).toUpperCase();
               while (steps.length() < 16) steps = "0" + steps;
               String fmtTime = String.format("%1$-11s", testTime[i]);
               String utcTime = df.format(new Date(testTime[i]*1000));

               OTPKey=generateTOTP(seed64, steps, "6",
                       "HmacSHA512");

               System.out.print("|  " + fmtTime + "  |  " + utcTime +
                       "  | " + steps + " |");
               System.out.println(OTPKey + "| SHA512 |");


               //               System.out.println(
//                       "+---------------+-----------------------+" +
//                               "------------------+--------+--------+");
//


           }
       }catch (final Exception e){
           System.out.println("Error : " + e);
       }


         return OTPKey;

   }

}
