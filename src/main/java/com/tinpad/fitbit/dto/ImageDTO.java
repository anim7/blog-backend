package com.tinpad.fitbit.dto;

import com.tinpad.fitbit.entities.Image;
import org.jetbrains.annotations.NotNull;

public class ImageDTO {

    private String imageID;

    private String name;

    private String type;

    private byte[] imageByte;

    public ImageDTO() {
    }

    public ImageDTO(Image image) {
        setImageID(image.getImageID());
        setName(image.getName());
        setType(image.getType());
        setImageByte(image.getImageByte());
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
