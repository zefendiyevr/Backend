package com.medilink.backend.Security;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.io.PrintStream;
import java.util.Enumeration;
@Component

 public class SecurityInterceptor implements HandlerInterceptor  {

    private static final Logger log = LoggerFactory.getLogger(SecurityInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        System.out.println("Security Interceptor preHandle ");
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("Security Interceptor posHandle ");
        log.info("[postHandle][" + request + "]");

    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (ex != null){
            ex.printStackTrace();
        }

        System.out.println("Security Interceptor afterCompletion ");
        log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
    }




}
