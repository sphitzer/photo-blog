package com.courterco.photoblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import com.courterco.photoblog.service.AlbumService;
import com.courterco.photoblog.domain.Album;
import com.courterco.photoblog.service.exception.AlbumAlreadyExistsException;

import javax.validation.Valid;

@RestController
public class AlbumController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumController.class);
    private final AlbumService albumService;

    @Autowired
    public AlbumController(final AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping(value = "/albums", method = RequestMethod.POST, consumes={"application/json"})
    public Album saveAlbum(@RequestBody @Valid final Album album) throws AlbumAlreadyExistsException{
        LOGGER.debug("Received request to create the {}", album);
        return albumService.saveAlbum(album);
    }

    @RequestMapping(value = "/albums", method = RequestMethod.GET, produces={"application/json"})
    public List<Album> listAlbums() {
        LOGGER.debug("Received request to list all albums");
        return albumService.getAlbumList();

    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.GET, produces={"application/json"})
    public Album singleAlbum(@PathVariable Long id) {
        LOGGER.debug("Received request to display the contents of a specific album");
        return albumService.getAlbum(id);
    }

    @RequestMapping(value = "/albums/{id}", method = RequestMethod.DELETE)
    public void deleteAlbum(@PathVariable Long id) {
        LOGGER.debug("Received request to delete a specific album");
        albumService.deleteAlbum(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleAlbumAlreadyExistsException(AlbumAlreadyExistsException e) {
        return e.getMessage();
    }
}
