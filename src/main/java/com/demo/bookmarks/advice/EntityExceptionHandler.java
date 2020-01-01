package com.demo.bookmarks.advice;

import com.demo.bookmarks.rest.CustomError;
import com.demo.bookmarks.rest.EntityNotFoundException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<CustomError> handleException(EntityNotFoundException e) {
        CustomError error = new CustomError(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


/* below is not correct */
    @ExceptionHandler({SQLException.class, NullPointerException.class, IndexOutOfBoundsException.class, IllegalArgumentException.class,InvalidDataAccessApiUsageException.class})
    public ResponseEntity<CustomError> handleException(IllegalArgumentException e) {
        CustomError error = new CustomError(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<CustomError>  handleException(Exception e) {
        CustomError error = new CustomError(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
