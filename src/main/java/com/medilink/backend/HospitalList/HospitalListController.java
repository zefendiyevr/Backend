package com.medilink.backend.HospitalList;

import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class HospitalListController {
    @Autowired
    public HospitalListService hospitalListService;


    @PostMapping("/hospitallist")
    public MedilinkResponsTmp HospitalList(@RequestHeader String CurrentDatetime,  @RequestHeader String Nonce, @RequestHeader String Token ,
                                             @RequestBody HospitalList hospitalList) {


        MedilinkResponsTmp  medilinkResponsTmp= hospitalListService.HospitalList(hospitalList.Lang);


        return medilinkResponsTmp;

    }
}
