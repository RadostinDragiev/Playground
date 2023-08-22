package com.cloudinary.config;

import com.cloudinary.service.CloudinaryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryService();
    }
}
