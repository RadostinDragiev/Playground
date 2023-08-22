package com.cloudinary.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public Cloudinary cloudinary() {
        Cloudinary cloudinary = new Cloudinary(System.getenv("CLOUDINARY_URL"));
        cloudinary.config.secure = true;

        return cloudinary;
    }
}
