package com.mbooking.error;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            BookNotFoundException.class,
            AuthorNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound(HttpServletResponse response, RuntimeException ex) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    // TODO: Don't propagate, handle at service layer!
    @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
    public void handleSQLException(
            HttpServletResponse response, ConstraintViolationException ex) throws IOException {
        response.sendError(HttpStatus.SEE_OTHER.value(), ex.getMessage());
    }


}
