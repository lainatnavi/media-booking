package com.mbooking.service;

class AuthorNotFoundException extends RuntimeException {
    AuthorNotFoundException(Long id) {
        super("Could not find author " + id);
    }
}
