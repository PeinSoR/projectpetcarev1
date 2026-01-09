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
                        "https://petcare-qsvz.onrender.com", // Para entrega del proyecto
                        "https://69611b2e90ee1a4783d8ac8c--petcare-frontend.netlify.app", // Para tarea
                        "https://dashing-custard-78baac.netlify.app", // Para tarea
                        "https://gorgeous-quokka-4c3398.netlify.app", // Para tarea
                        "https://dazzling-biscochitos-fd0c40.netlify.app" // Para tarea
                )
                .allowedMethods(
                        "GET", "POST", "PUT", "DELETE", "OPTIONS"
                )
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
