package com.medilink.backend.Security;


import com.google.gson.Gson;
import com.medilink.backend.ModelDto.Data;
import com.medilink.backend.ModelDto.EnumTemp;
import com.medilink.backend.ModelDto.MedilinkResponsTmp;
import com.medilink.backend.OTPGenerator.OTPGeneratorServises;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Enumeration;
@Component
public class LoggerInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
    OTPGeneratorServises otpGeneratorServises=new OTPGeneratorServises();
    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

            String requestData = "[Metod Type: "+request.getMethod()+ "]  Remute address:] -["+request.getRemoteAddr()+request.getRequestURI()+"]      request Json :";//+request.getReader().lines().collect(Collectors.joining());
            log.info("** Medlink Log type:Request ---"+ requestData);
            log.info("**Get Parametr request:"+getParameters(request));
            Integer responseCod=response.getStatus();


            System.out.println(responseCod);
            if (responseCod==200) {
                if (!CheckConnectionKey(request.getHeader("CurrentDatetime"), request.getHeader("Token"))) {
                    response.getWriter().write(new Gson().toJson(createJson(403, "403 - Forbidden")));
                    response.setStatus(403);
                    return false;
                }
            } else  {

                response.getWriter().write(new Gson().toJson(createJson( responseCod, "Server Internal Error")));
                response.setStatus(responseCod);
                return false;
            }


        return true;
    }



    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {

        log.info("** Medlink Log type:Response ---Status:"+response.getStatus()+"  Respons Message boady:"+response);




    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (ex != null){
            ex.printStackTrace();
        }

        log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
    }

    private String getRemoteAddr(HttpServletRequest request) {
        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
        if (ipFromHeader != null && ipFromHeader.length() > 0) {
            log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
            return ipFromHeader;
        }
        return request.getRemoteAddr();
    }
    private String getParameters(HttpServletRequest request) {
        StringBuffer posted = new StringBuffer();
        Enumeration<?> e = request.getParameterNames();
        if (e != null) {
            posted.append("?");
        }
        while (e.hasMoreElements()) {
            if (posted.length() > 1) {
                posted.append("&");
            }
            String curr = (String) e.nextElement();
            posted.append(curr + "=");
            if (curr.contains("password")
                    || curr.contains("pass")
                    || curr.contains("pwd")) {
                posted.append("*****");
            } else {
                posted.append(request.getParameter(curr));
            }
        }
        String ip = request.getHeader("X-FORWARDED-FOR");
        String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
        System.out.print(ipAddr);
        if (ipAddr!=null && !ipAddr.equals("")) {
            posted.append("&_psip=" + ipAddr);
        }
        return posted.toString();
    }

   // Check connection key
    private boolean CheckConnectionKey(String HeaderKeyDateTime, String BodyKey) throws ParseException {
        String GeneretedKey=MedilinkLogikEncription(otpGeneratorServises.DatetimeToLong(HeaderKeyDateTime).toString(),
                HeaderKeyDateTime.substring(0,4),HeaderKeyDateTime.substring(5,7),
                HeaderKeyDateTime.substring(8,10));
            return GeneretedKey.trim().equals(BodyKey.trim());
     }

   //Generate  Json Message for Forbitten error
     private MedilinkResponsTmp createJson( Integer code, String Message ){
         MedilinkResponsTmp medilinkResponsTmp=new MedilinkResponsTmp();
         Data data = new Data();
         ArrayList<EnumTemp> enumTemp= new ArrayList<>();
         enumTemp.add(new EnumTemp(code, Message));
         //enumTemp.add(new EnumTemp(code+1, Message));
         data.data=enumTemp;
         medilinkResponsTmp.code=code.toString();
         medilinkResponsTmp.message=Message;
         medilinkResponsTmp.response=data;
         return medilinkResponsTmp;
    }
     //encription Algoritm for Medilink
     private String MedilinkLogikEncription(String TOTP, String Il, String Ay, String Gun ){
         return MD5(MD5(MD5(MD5(TOTP)+Il)+Ay)+Gun);
     }



     //MD5 Generator
     private String MD5(String InputKey) {

         String ReturnedMD5String = null;

         try {
             // Create MessageDigest instance for MD5
             MessageDigest md = MessageDigest.getInstance("MD5");

             // Add password bytes to digest

             md.update(InputKey.getBytes());

             // Get the hash's bytes
             byte[] bytes = md.digest();

             // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
             StringBuilder sb = new StringBuilder();
             for (int i = 0; i < bytes.length; i++) {
                 sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
             }

             // Get complete hashed password in hex format
             ReturnedMD5String = sb.toString();
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         }
         return ReturnedMD5String;


      }
}
