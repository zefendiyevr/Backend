package com.medilink.backend.HelpfulFunc;

import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class HelpfulFuncController {
    @Autowired
    HelpfulFuncService helpfulFuncService;
    @PostMapping("/v1/CheckPatientOrderNo")
    public MedilinkResponsTmp CheckPatientOrderNo(@RequestHeader String CurrentDatetime, String Token ,
                                           @RequestBody _CheckPatientOrderNo _checkPatientOrderNo ) {





        return helpfulFuncService.CheckPatientOrderNo(_checkPatientOrderNo.HospId, _checkPatientOrderNo.MemberId, _checkPatientOrderNo.OrdNo);

    }


}
