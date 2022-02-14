package com.tinpad.fitbit.entities;

import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;
import com.tinpad.fitbit.dto.PostDTO;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GenericGenerator(name = "post_id", strategy = "com.tinpad.fitbit.generators.PostIDGenerator")
    @GeneratedValue(generator = "post_id")
    @Column(length = 9, name = "post_id")
    private String postID;

    private String title;

    @Column(length = 5000)
    private String summary;

    @Column(length = 1000000000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    private String metaTitle;

    @Column(unique = true)
    private String slug;

    private Date createdAt;

    private Date updatedAt;

    private Date publishedAt;

    private Long views;

    private Float rating;

    private Float timeToRead;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image titleImage;

    public Post() {
    }

    public Post(@NotNull PostDTO postDTO) {
        setPostID(postDTO.getPostID());
        setTitle(postDTO.getTitle());
        setSummary(postDTO.getSummary());
        setContent(postDTO.getContent());
        setMetaTitle(postDTO.getMetaTitle());
        setCreatedAt(postDTO.getCreatedAt());
        setUpdatedAt(postDTO.getUpdatedAt());
        setPublishedAt(postDTO.getPublishedAt());
        setAuthor(new User(postDTO.getAuthor()));
        setRating(postDTO.getRating());
        setViews(postDTO.getViews());
        setTimeToRead(postDTO.getTimeToRead());
        setTitleImage(new Image(postDTO.getTitleImage()));
        setSlug(postDTO.getSlug());
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
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

    public Image getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(Image titleImage) {
        this.titleImage = titleImage;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
