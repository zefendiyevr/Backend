package com.medilink.backend.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.medilink.backend.Security.*;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.security.Security;

@Configuration
public class MedlinkBackend implements WebMvcConfigurer {
      //private  LoggerInterceptor loggerInterceptor;

      @Autowired
       private LoggerInterceptor loggerInterceptor;


      @Override
      public void addInterceptors(InterceptorRegistry registry) {registry.addInterceptor(loggerInterceptor);
      }




}
