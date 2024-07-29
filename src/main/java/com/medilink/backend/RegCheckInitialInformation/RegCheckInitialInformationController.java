package com.medilink.backend.RegCheckInitialInformation;

import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class RegCheckInitialInformationController {

@Autowired
public RegCheckInitialInformationService regCheckInitialInformationService;

    @PostMapping("/RegisterStepOne")
    public MedilinkResponsTmp RegisterStepOne(@RequestHeader  String CurrentDatetime, String Token , @RequestBody RegisterStepOne registerStepOne) {

       return regCheckInitialInformationService.RegisterStepOne(registerStepOne.RegTime, registerStepOne.IpAdd, registerStepOne.DevId,
                                                          registerStepOne.HospId, registerStepOne.ReferralVal, registerStepOne.FinCode, registerStepOne.OrdNo);



    }

    @PostMapping("/RegisterStepTwoGet")
    public MedilinkResponsTmp RegisterStepTwoGet(@RequestHeader  String CurrentDatetime, String Token ,
                                                 @RequestBody RegisterStepTwoGet registerStepTwoGet) {

        return regCheckInitialInformationService.RegisterStepTowGet(registerStepTwoGet.PId, registerStepTwoGet.RId);



    }
    @PostMapping("/RegisterStepTwoAccept")
    public MedilinkResponsTmp RegisterStepTwoAccept(@RequestHeader  String CurrentDatetime, String Token ,
                                                 @RequestBody RegisterStepTwoAccept registerStepTwoAccept) {

        return regCheckInitialInformationService.RegisterStepTowAccept(registerStepTwoAccept.PId, registerStepTwoAccept.RId);

    }

}
