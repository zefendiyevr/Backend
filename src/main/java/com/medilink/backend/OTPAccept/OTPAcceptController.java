package com.medilink.backend.OTPAccept;

import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("api/v1/")
public class OTPAcceptController {
    @Autowired
    OTPAcceptServise otpAcceptServise;
    @PostMapping("/RegOTPMobile")
    public MedilinkResponsTmp RegOTPMobile(@RequestHeader String CurrentDatetime, String Token ,
                                           @RequestBody OTPAccept otpAccept) throws ParseException {

        return otpAcceptServise.RegOTPMobile(otpAccept.PId,otpAccept.Otp ,otpAccept.SendTo, otpAccept.RId);
                //RegOTPMobile(otpAccept.PId, otpAccept.SendTo, otpAccept.RId);



    }
    @PostMapping("/CheckOtpMobile")
    public MedilinkResponsTmp CheckOtpMobile(@RequestHeader String CurrentDatetime, String Token ,
                                           @RequestBody OTPCheck otpCheck) throws ParseException {

        return otpAcceptServise.CheckOtpMobile(otpCheck.OTP, otpCheck.OtpId);

    }

}
