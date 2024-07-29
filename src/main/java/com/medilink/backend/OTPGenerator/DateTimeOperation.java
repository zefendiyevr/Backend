package com.medilink.backend.OTPGenerator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeOperation {
    public String DadetimeString;

    public Date StringToDatetime() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(DadetimeString);

        //String specifiedDateString = sdf.format(date);
        //long actualTimestamp = sdf.parse(specifiedDateString).getTime();
        //assertEquals(1700010123000L, actualTimestamp);

      return date;
    }


    public Long DatetimeToLong() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(DadetimeString);

        String specifiedDateString = sdf.format(date);
        long actualTimestamp = sdf.parse(specifiedDateString).getTime();
        /* assertEquals(1700010123000L, actualTimestamp); */

        return actualTimestamp;
    }
}
