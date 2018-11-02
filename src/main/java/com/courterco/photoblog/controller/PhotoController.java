package com.courterco.photoblog.controller;

import com.courterco.photoblog.service.PhotoService;
import com.courterco.photoblog.domain.Photo;
import com.courterco.photoblog.service.exception.PhotoAlreadyExistsException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PhotoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoController.class);
    private final PhotoService photoService;

    @Autowired
    public PhotoController(final PhotoService photoService){ this.photoService = photoService; }

    @RequestMapping(value = "/photos", method = RequestMethod.POST, consumes={"application/json"})
    public Photo savePhoto(@RequestBody @Valid final Photo photo) throws PhotoAlreadyExistsException{

        LOGGER.debug("Received request to create the {}", photo);
        return photoService.savePhoto(photo);
    }

    @RequestMapping(value = "/photos", method = RequestMethod.GET, produces={"application/json"})
    public List<Photo> listPhotos() {
        LOGGER.debug("Received request to list all photos");
        return photoService.getPhotoList();

    }

    @RequestMapping(value = "/photos/{id}", method = RequestMethod.GET, produces={"application/json"})
    public Photo singlePhoto(@PathVariable Long id) {
        LOGGER.debug("Received request to display the contents of a specific photo");
        return photoService.getPhoto(id);
    }


    @RequestMapping(value = "/photos/{id}", method = RequestMethod.DELETE)
    public void deletePhoto(@PathVariable Long id) {
        LOGGER.debug("Received request to delete a specific photo");
        photoService.deletePhoto(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handlePhotoAlreadyExistsException(PhotoAlreadyExistsException e) {
        return e.getMessage();
    }

}
