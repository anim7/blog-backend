package com.tinpad.fitbit.controllers;

import com.tinpad.fitbit.dto.ImageDTO;
import com.tinpad.fitbit.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<ImageDTO> getImages(@RequestParam(name = "id", required = false) String id) {
        return imageService.getImages(id);
    }

    @PostMapping
    public ImageDTO addImage(@RequestParam(name = "image") MultipartFile file) throws IOException {
        return imageService.addImage(file);
    }

    @PutMapping
    public ImageDTO updateImage(@RequestParam(name = "id") String id, @RequestParam(name = "image") MultipartFile file) throws IOException {
        return imageService.updateImage(id, file);
    }

    @DeleteMapping
    public List<ImageDTO> deleteImages(@RequestParam(required = false, name = "id") String id) {
        return imageService.deleteImages(id);
    }

}
