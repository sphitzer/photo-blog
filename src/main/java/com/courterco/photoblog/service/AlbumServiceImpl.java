package com.courterco.photoblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import com.courterco.photoblog.domain.Album;
import com.courterco.photoblog.repository.AlbumRepository;
import com.courterco.photoblog.service.exception.AlbumAlreadyExistsException;

@Service
@Validated
public class AlbumServiceImpl implements AlbumService{

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumServiceImpl.class);
    private final AlbumRepository repository;

    @Autowired
    public AlbumServiceImpl(final AlbumRepository repository) { this.repository = repository; }

    @Override
    @Transactional
    public Album saveAlbum(@NotNull @Valid final Album album) throws AlbumAlreadyExistsException {
        LOGGER.debug("Creating {}", album);
        Album existing = repository.findById(album.getId()).orElse(null);

        if (existing != null) {
            throw new AlbumAlreadyExistsException(
                    String.format("There already exists an album with id=%s", existing.getId()));
        }

        return repository.save(album);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Album> getAlbumList() {
        LOGGER.debug("Getting list of all albums");
        return repository.findAll();
    }

    @Override
    public Album getAlbum(Long albumId) {
        return repository.findById(albumId).orElse(null);
    }

    @Override
    @Transactional
    public void deleteAlbum(final Long albumId) {
        LOGGER.debug("deleting {}", albumId);
        Album albumToDelete = getAlbum(albumId);
        repository.delete(albumToDelete);
    }
}
