package com.cloudinary.service;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    @Autowired
    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    /**
     * ObjectUtils.asMap
     * <p>
     * Define file type
     * - resource_type -> video /auto/ raw
     * <p>
     * Use the uploaded file name
     * - use_filename -> true / false
     * <p>
     * Cloudinary will add random suffix after the file name to make it unique
     * - unique_filename -> true / false
     * <p>
     * Put custom name to the file
     * - public_id -> (custom)
     * <p>
     * Create folder
     * - folder -> "pets/my_dog"
     */
    public void uploadFile() throws IOException {
        Uploader uploader = this.cloudinary.uploader();

        Map upload = uploader.upload("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Olympic_rings_without_rims.svg/2880px-Olympic_rings_without_rims.svg.png", ObjectUtils.emptyMap());

        log.info("File uploaded to URL -> " + upload.get("secure_url"));
    }
}
