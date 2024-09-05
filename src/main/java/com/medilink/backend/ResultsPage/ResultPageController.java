package com.medilink.backend.ResultsPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ResultPageController {
    @Autowired
    ResultsPageServices resultsPageServices;
    @PostMapping("v1/ListofNewReports")
    public String ListofNewReports(
            @RequestHeader String CurrentDatetime,
            @RequestHeader String Nonce,
            @RequestHeader String Token,
            @RequestHeader String Cod1,
            @RequestHeader String Cod2,
            @RequestHeader String Cod3){


        System.out.println(Cod1+Cod2);
        //  String SS=dayTokenGetService.dayTokenGet(Cod1,Cod2);
        return resultsPageServices.listofNewReports(Cod1,Cod2,Cod3);
    }


}
