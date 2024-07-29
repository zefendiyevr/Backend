package com.medilink.backend.OTPGenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/OTP/")
public class  OPTGeneratorController {
    private final com.medilink.backend.OTPGenerator.OTPGeneratorServises OTPGeneratorServises;

    public OPTGeneratorController(com.medilink.backend.OTPGenerator.OTPGeneratorServises otpGeneratorServises) {
        OTPGeneratorServises = otpGeneratorServises;
    }



    @GetMapping("/OTPGenerator")
    public  String OTPGenerator(){




        LocalDateTime myObj = LocalDateTime.now();
        System.out.println(LocalDateTime.now().toString());
       // Long tt=(Long)LocalDateTime.now();
        return OTPGeneratorServises.TOTPgenetator(272772727,30);



    }
}
