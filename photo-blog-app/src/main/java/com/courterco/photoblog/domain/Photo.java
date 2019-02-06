package com.courterco.photoblog.domain;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Photo {



    @Id
    @NotNull
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Size(max = 64)
    @Column(name = "filePath", nullable = false)
    private String filePath;

    @NotNull
    @Column(name = "uploadDate", nullable = false)
    private Date uploadDate;

    @Size(max = 64)
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "albumId", nullable = false)
    private Long albumId;

    public Photo() {
    }

    public Photo(final Long id, final String filePath, final Date uploadDate,
                 final String title, final Long albumId) {

        this.id = id;
        this.filePath = filePath;
        this.uploadDate = uploadDate;
        this.title = title;
        this.albumId = albumId;
    }

    public Long getId() { return this.id; }
    public String getFilePath() { return this.filePath; }
    public Date getUploadDate() { return this.uploadDate; }
    public String getTitle() { return this.title; }
    public Long getAlbumId() { return this.albumId; }

    public void setTitle(String title) { this.title = title; }
    public void setAlbumId(Long albumId) { this.albumId = albumId; }

    @Override
    public String toString() {
        return "Album{id=" + this.id
                + ",filePath=" + this.filePath
                + ",uploadDate=" + this.uploadDate
                + ",title=" + this.title
                + ",albumId=" + this.albumId + "}";
    }
}
