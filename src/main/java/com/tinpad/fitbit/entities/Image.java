package com.tinpad.fitbit.entities;

import com.tinpad.fitbit.dto.ImageDTO;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GenericGenerator(name = "image_id", strategy = "com.tinpad.fitbit.generators.ImageIDGenerator")
    @GeneratedValue(generator = "image_id")
    @Column(length = 9, name = "image_id")
    private String imageID;

    private String name;

    private String type;

    @Column(length = 1000000000, nullable = false)
    private byte[] imageByte;

    public Image() {
    }

    public Image(String name, String type, byte[] imageByte) {
        setName(name);
        setType(type);
        setImageByte(imageByte);
    }

    public Image(String imageID, String name, String type, byte[] imageByte) {
        setImageID(imageID);
        setName(name);
        setType(type);
        setImageByte(imageByte);
    }

    public Image(ImageDTO imageDTO) {
        setImageID(imageDTO.getImageID());
        setName(imageDTO.getName());
        setType(imageDTO.getType());
        setImageByte(imageDTO.getImageByte());
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        if (imageID != null && imageID.length() == 9) {
            this.imageID = imageID;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        if (name.length() < 255) {
            this.name = name;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(@NotNull String type) {
        if (type.length() < 255) {
            this.type = type;
        }
    }

    public byte[] getImageByte() {
        return imageByte;
    }

    public void setImageByte(byte[] imageByte) {
        this.imageByte = imageByte;
    }

}
