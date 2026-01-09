package com.projectframe.mx.petcare.dominio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(
                        "https://petcare-qsvz.onrender.com",
                        "https://69611b2e90ee1a4783d8ac8c--petcare-frontend.netlify.app"
                )
                .allowedMethods(
                        "GET", "POST", "PUT", "DELETE", "OPTIONS"
                )
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
