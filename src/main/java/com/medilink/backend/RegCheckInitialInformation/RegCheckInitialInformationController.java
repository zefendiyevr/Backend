package com.medilink.backend.RegCheckInitialInformation;

import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class RegCheckInitialInformationController {
    @Autowired
    private HttpServletRequest request;

@Autowired
public RegCheckInitialInformationService regCheckInitialInformationService;

    @PostMapping("/RegisterStepOne")
    public MedilinkResponsTmp RegisterStepOne(@RequestHeader  String CurrentDatetime,@RequestHeader String Nonce, @RequestHeader String Token , @RequestBody RegisterStepOne registerStepOne) {

         String ConnectionIPAddress=request.getRemoteAddr();
        return regCheckInitialInformationService.RegisterStepOne(registerStepOne.RegTime, ConnectionIPAddress, registerStepOne.DevId,
                                                          registerStepOne.HospId, registerStepOne.ReferralVal, registerStepOne.FinCode, registerStepOne.OrdNo);



    }

    @PostMapping("/RegisterStepTwoGet")
    public MedilinkResponsTmp RegisterStepTwoGet(@RequestHeader  String CurrentDatetime, String Token ,
                                                 @RequestBody RegisterStepTwoGet registerStepTwoGet) {

        return regCheckInitialInformationService.registerStepTowGet(registerStepTwoGet.PId, registerStepTwoGet.RId);



    }
    @PostMapping("/RegisterStepTwoAccept")
    public MedilinkResponsTmp RegisterStepTwoAccept(@RequestHeader  String CurrentDatetime,@RequestHeader String Nonce ,@RequestHeader String Token ,
                                                 @RequestBody RegisterStepTwoAccept registerStepTwoAccept) {

        return regCheckInitialInformationService.RegisterStepTowAccept(registerStepTwoAccept.PId, registerStepTwoAccept.RId,"");

    }

}
