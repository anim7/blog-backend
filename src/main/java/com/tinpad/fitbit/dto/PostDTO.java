package com.tinpad.fitbit.dto;

import com.tinpad.fitbit.entities.Post;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;

public class PostDTO {

    private String postID;

    private String title;

    private String metaTitle;

    private String summary;

    private String content;

    private UserDTO author;

    private String slug;

    private Date createdAt;

    private Date updatedAt;

    private Date publishedAt;

    private Long views;

    private Float rating;

    private Float timeToRead;

    private ImageDTO titleImage;

    public PostDTO() {
    }

    public PostDTO(@NotNull Post post) {
        setPostID(post.getPostID());
        setTitle(post.getTitle());
        setMetaTitle(post.getMetaTitle());
        setSummary(post.getSummary());
        setContent(post.getContent());
        setCreatedAt(post.getCreatedAt());
        setPublishedAt(post.getPublishedAt());
        setUpdatedAt(post.getUpdatedAt());
        setRating(post.getRating());
        setViews(post.getViews());
        setTimeToRead(post.getTimeToRead());
        setAuthor(new UserDTO(post.getAuthor()));
        setTitleImage(new ImageDTO(post.getTitleImage()));
        setSlug(post.getSlug());
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
        if (postID != null && postID.length() == 9) {
            this.postID = postID;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(@NotNull String title) {
        if (title.length() > 0 && title.length() <= 255) {
            this.title = title;
        }
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(@NotNull String summary) {
        if (summary.length() > 0 && summary.length() <= 5000) {
            this.summary = summary;
        }
    }

    public String getContent() {
        return content;
    }

    public void setContent(@NotNull String content) {
        if (content.length() > 0 && content.length() <= 1000000000) {
            this.content = content;
        }
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(@NotNull String metaTitle) {
        if (metaTitle.length() > 0 && metaTitle.length() <= 255) {
            this.metaTitle = metaTitle;
        }
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        if (views >= 0) {
            this.views = views;
        }
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
    }

    public Float getTimeToRead() {
        return timeToRead;
    }

    public void setTimeToRead(Float timeToRead) {
        if (timeToRead >= 0) {
            this.timeToRead = timeToRead;
        }
    }

    public ImageDTO getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(ImageDTO titleImage) {
        this.titleImage = titleImage;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
