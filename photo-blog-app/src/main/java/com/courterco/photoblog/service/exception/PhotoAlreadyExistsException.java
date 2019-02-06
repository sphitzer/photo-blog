package com.courterco.photoblog.service.exception;

public class PhotoAlreadyExistsException extends Exception {

    public PhotoAlreadyExistsException(String exceptionText){
        super(exceptionText);
    }
}

