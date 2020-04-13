package com.mbooking.error;

public class AuthorExistsException extends RuntimeException {
    AuthorExistsException(Long id) {
        super("Author " + id + " already exists");
    }
}
