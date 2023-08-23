package com.cloudinary.service;

import com.cloudinary.*;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public void uploadFile() throws IOException {
        Uploader uploader = this.cloudinary.uploader();

        Map upload = uploader.upload("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Olympic_rings_without_rims.svg/2880px-Olympic_rings_without_rims.svg.png", ObjectUtils.emptyMap());

        log.info("File uploaded to URL -> " + upload.get("secure_url"));
        log.info("File public id -> " + upload.get("public_id"));
    }

    public void fetchFile() throws Exception {
        Api api = this.cloudinary.api();

        api.resources(ObjectUtils.asMap("", ""));
    }

    public void deleteFile(String[] publicIds) throws Exception {
//        Uploader uploader = this.cloudinary.uploader();
//        uploader.destroy("publicId", ObjectUtils.asMap("invalidate", true));

        // Admin API
        Api api = this.cloudinary.api();
        ApiResponse invalidate = api.deleteResources(Arrays.asList(publicIds), ObjectUtils.asMap("invalidate", true));
        Map<String, String> map = (Map<String, String>) invalidate.get("deleted");
        map.forEach((key, value) -> log.warn(String.format("For public id: %s response is %s", key, value)));
        System.out.println();
    }
}
