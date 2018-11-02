package com.courterco.photoblog.service;

import com.courterco.photoblog.domain.Album;
import com.courterco.photoblog.domain.Photo;
import com.courterco.photoblog.repository.AlbumRepository;
import com.courterco.photoblog.repository.PhotoRepository;
import com.courterco.photoblog.service.exception.PhotoAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated
public class PhotoServiceImpl implements PhotoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoServiceImpl.class);
    private final PhotoRepository repository;

    @Autowired
    public PhotoServiceImpl(final PhotoRepository repository) { this.repository = repository; }

    @Override
    @Transactional
    public Photo savePhoto(@NotNull @Valid final Photo photo) throws PhotoAlreadyExistsException{

        return repository.save(photo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Photo> getPhotoList(){
        LOGGER.debug("Getting list of all photos");
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Photo> getPhotosInAlbum(Long albumId){
        LOGGER.debug("Getting list of photos with albumId: {}", albumId);
        return repository.findByAlbumId(albumId);
    }

    @Override
    public Photo getPhoto(Long photoId){
        return repository.findById(photoId).orElse(null);
    }

    @Override
    @Transactional
    public void deletePhoto(final Long photoId){
        LOGGER.debug("deleting {}", photoId);
        Photo photoToDelete = getPhoto(photoId);
        repository.delete(photoToDelete);

    }
}
