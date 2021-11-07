package com.example.getmesocial2.model;
import com.example.getmesocial2.validation.ValidName;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class Comment {

    private String id;
    private String photoId;

    @Length(min = 5)
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @ValidName
    private String createdBy;
    private Date dateCreated;
}
