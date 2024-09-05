package com.medilink.backend.ResultsPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultsPageServices {
@Autowired
ResultsPageRepository resultsPageRepository;
    public String listofNewReports(String Cod1, String Cod2, String Cod3){


        List<?> ReportsResults= resultsPageRepository.listofNewReports(Cod1,Cod2,Cod3);


        return "LIst Of reports";

    }

}
