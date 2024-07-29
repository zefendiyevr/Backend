package com.medilink.backend.DatabaseConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
@PropertySource("classpath:application.properties")
public class ServerProperties {

    Resource resource = new ClassPathResource("/application.properties");
    Properties props;

    {
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
