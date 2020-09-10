package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.MultipartConfigElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class ProjectConfig {

    @Value("${question.typename}")
    private String typeNames;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation("/myData/tmp");
        return factory.createMultipartConfig();
    }

    @Bean
    public List<String> sortByTypes() {
        //String typeNames = environment.getProperty("question.typename");
        String[] types = typeNames.split(" ");
        List<String> result = new ArrayList<>(types.length);
        Collections.addAll(result, types);
        return Collections.unmodifiableList(result);
    }


}
