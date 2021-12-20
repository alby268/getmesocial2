package com.example.getmesocial2.model;
import com.example.getmesocial2.validation.ValidName;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Photo {

    @Id
    private String id;

    public Photo(String id, String albumId, String photoUrl, String createdBy, Date dateCreated) {
        this.id = id;
        this.albumId = albumId;
        this.photoUrl = photoUrl;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    private String albumId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
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

    private String photoUrl;

    @ValidName
    private String createdBy;
    private Date dateCreated;
}
