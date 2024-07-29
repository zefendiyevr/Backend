package com.medilink.backend.SMSSend;

import com.medilink.backend.ModelDto.SMSResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
//@RequestMapping("api/v1/")
public class SMSSendController  {


   // @GetMapping("/smssend")
    public SMSResponse smssend(@RequestHeader String CurrentDatetime, @RequestHeader String Token) {
         return smssend("dskmflkdsflkdsklfj","994502873060");
    }

}
