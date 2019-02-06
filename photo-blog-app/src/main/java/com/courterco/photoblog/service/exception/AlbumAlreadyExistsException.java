package com.courterco.photoblog.service.exception;

public class AlbumAlreadyExistsException extends Exception {

    public AlbumAlreadyExistsException(String exceptionText){
        super(exceptionText);
    }
}

