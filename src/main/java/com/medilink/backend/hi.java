package com.medilink.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class hi {

@GetMapping("/")
    public String hi(@RequestHeader String CurrentDatetime, String Token){


         return "MedLink API Services";

    }

}
