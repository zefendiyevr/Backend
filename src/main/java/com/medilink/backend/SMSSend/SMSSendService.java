package com.medilink.backend.SMSSend;
import com.medilink.backend.ModelDto.SMSResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class SMSSendService {
    @Autowired
    SMSSend smsSend;
    public SMSResponse smssend( String SMSBody, String ToGsm)  {

        smsSend.setMessageBoady(SMSBody);
        smsSend.setTogsm(ToGsm);
        String HttpUrl=smsSend.generateURL();
        System.out.println(HttpUrl);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(HttpUrl))
                .header("X-RapidAPI-Host", "jokes-by-api-ninjas.p.rapidapi.com")
                .header("X-RapidAPI-Key", "your-rapidapi-key")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(response.body());
        return smsSendMap(response.body());
    }


    public SMSResponse smsSendMap(String response){
        SMSResponse smsResponse=new SMSResponse();
        List ItemsLayer= List.of(response.split("&"));
        smsResponse.setErrno(smsSendMapSub((String)ItemsLayer.get(0)));
        smsResponse.setErrtext(smsSendMapSub((String)ItemsLayer.get(1)));
        smsResponse.setMessage_id(smsSendMapSub((String)ItemsLayer.get(2)));
        smsResponse.setCharge(smsSendMapSub((String)ItemsLayer.get(3)));
        smsResponse.setBalance(smsSendMapSub((String)ItemsLayer.get(4)));
        return  smsResponse;
    }

    public String smsSendMapSub(String responseSub){
        List ItemsLayer= List.of(responseSub.split("=", 2));
        return  (String)ItemsLayer.get(1);
    }

}
