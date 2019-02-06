package com.courterco.photoblog.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import com.courterco.photoblog.domain.Album;
import com.courterco.photoblog.service.exception.AlbumAlreadyExistsException;


public interface AlbumService {
    Album saveAlbum(@NotNull @Valid final Album album) throws AlbumAlreadyExistsException;
    List<Album> getAlbumList();
    Album getAlbum(Long albumId);
    void deleteAlbum(final Long albumId);
}
