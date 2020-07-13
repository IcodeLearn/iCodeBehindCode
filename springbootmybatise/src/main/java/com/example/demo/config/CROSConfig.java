package com.example.demo.config;

import com.example.demo.handle.CustomInterceptorHandle;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CROSConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("*");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomInterceptorHandle())
                .addPathPatterns("/**")
                .excludePathPatterns("/uploadFile");
    }

}
