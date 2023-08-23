package com.cloudinary.web;

import com.cloudinary.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        this.cloudinaryService.uploadFile();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Void> deleteFile(@RequestParam(name = "publicId") String publicId) throws Exception {
        this.cloudinaryService.deleteFile(new String[] {"tb8da82ao9nqjualdjtj", "olympic_flag2"});
        return ResponseEntity.ok().build();
    }
}
