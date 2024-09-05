package com.medilink.backend.DayTokenGet;

import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class DayTokenGetController {

    @Autowired
    DayTokenGetService dayTokenGetService;
    @PostMapping("/DayTokenGet")
    public MedilinkResponsTmp DaytokenGet(
            @RequestHeader String CurrentDatetime,
            @RequestHeader String Nonce,
            @RequestHeader String Token,
            @RequestHeader String Cod1,
            @RequestHeader String Cod2){


        System.out.println(Cod1+Cod2);
      //  String SS=dayTokenGetService.dayTokenGet(Cod1,Cod2);
        return dayTokenGetService.dayTokenGet(Cod1,Cod2);
    }

}
