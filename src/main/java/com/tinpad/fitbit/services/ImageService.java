package com.tinpad.fitbit.services;

import com.tinpad.fitbit.dto.ImageDTO;
import com.tinpad.fitbit.entities.Image;
import com.tinpad.fitbit.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<ImageDTO> getImages(String id) {
        if (id != null) {
            Image image = imageRepository.findById(id).get();
            image.setImageByte(decompressBytes(image.getImageByte()));
            return List.of(new ImageDTO(image));
        }
        return getImages();
    }

    public List<ImageDTO> getImages() {
        List<Image> images = imageRepository.findAll();
        List<ImageDTO> imageDTOs = new ArrayList<>();
        for (Image image : images) {
            image.setImageByte(decompressBytes(image.getImageByte()));
            imageDTOs.add(new ImageDTO(image));
        }
        return imageDTOs;
    }

    public ImageDTO addImage(MultipartFile file) throws IOException {
        Image image = new Image(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
        imageRepository.save(image);
        image.setImageByte(decompressBytes(image.getImageByte()));
        return new ImageDTO(image);
    }

    public ImageDTO updateImage(String id, MultipartFile file) throws IOException {
        Image image = new Image(id, file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
        imageRepository.saveAndFlush(image);
        image.setImageByte(decompressBytes(image.getImageByte()));
        return new ImageDTO(image);
    }

    public List<ImageDTO> deleteImages(String id) {
        if (id != null) {
            List<ImageDTO> image = getImages(id);
            imageRepository.deleteById(id);
            return image;
        }
        return deleteImages();
    }

    public List<ImageDTO> deleteImages() {
        List<ImageDTO> images = getImages();
        imageRepository.deleteAll();
        return images;
    }

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[data.length];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[data.length];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

}
