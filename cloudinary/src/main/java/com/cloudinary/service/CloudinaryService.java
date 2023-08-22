package com.cloudinary.service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CloudinaryService {
    @Value("${CLOUD_NAME}")
    private String CLOUD_NAME;

    @Value("${API_KEY}")
    private String API_KEY;

    @Value("${API_SECRET}")
    private String API_SECRET;

    public CloudinaryService() {
    }

    public void doSmth() throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", CLOUD_NAME,
                "api_key", API_KEY,
                "api_secret", API_SECRET));

        Map upload = cloudinary.uploader().upload(new File("src/main/resources/files/Olympic_rings_without_rims.svg.png"),
                ObjectUtils.asMap("public_id", "olympic_flag"));

        System.out.println();
    }
}
