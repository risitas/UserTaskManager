package com.smzynm.UserTaskManager.controller;

import com.smzynm.UserTaskManager.services.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final CloudinaryService cloudinaryService;

    @PostMapping()
    public ResponseEntity<?> upImage(@RequestParam("file") MultipartFile file)
            throws Exception {
        File image = cloudinaryService.convert(file);
        if (file == null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("error uploading image");
        }
        Map data = cloudinaryService.upImage(image, "userTaskManager");
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable("id") String id) throws Exception{
        Map data = cloudinaryService.deleteImage(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
