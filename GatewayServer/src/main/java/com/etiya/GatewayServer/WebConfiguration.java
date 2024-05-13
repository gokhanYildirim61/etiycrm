package com.etiya.GatewayServer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Tüm kökenlere izin ver
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*") // Tüm başlıklara izin ver
                .exposedHeaders("Access-Control-Allow-Origin"); // Bu başlığın istemci tarafından okunabilmesini sağlar
    }
}