package com.cloudinary.web;

import com.cloudinary.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {
    private final CloudinaryService cloudinaryService;

    @Autowired
    public UserController(CloudinaryService cloudinaryService) {
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadProfilePicture() throws IOException {
        cloudinaryService.doSmth();
        return ResponseEntity.ok().build();
    }
}
