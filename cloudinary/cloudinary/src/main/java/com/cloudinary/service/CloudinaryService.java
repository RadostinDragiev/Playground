package com.cloudinary.service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CloudinaryService {
    public CloudinaryService() {
    }

    public void doSmth() throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dwry67csj",
                "api_key", "534642968439217",
                "api_secret", "V_zS5twGbDgEK3A9cNM3raNEaR4"));

        Map upload = cloudinary.uploader().upload(new File("src/main/resources/files/Olympic_rings_without_rims.svg.png"),
                ObjectUtils.asMap("public_id", "olympic_flag"));

        System.out.println();
    }
}
