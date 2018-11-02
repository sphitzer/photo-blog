package com.courterco.photoblog.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import com.courterco.photoblog.domain.Photo;
import com.courterco.photoblog.service.exception.PhotoAlreadyExistsException;


public interface PhotoService {
    Photo savePhoto(@NotNull @Valid final Photo photo) throws PhotoAlreadyExistsException;
    List<Photo> getPhotoList();
    List<Photo> getPhotosInAlbum(Long albumId);
    Photo getPhoto(Long photoId);
    void deletePhoto(final Long photoId);
}
