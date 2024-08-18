package org.africa.semicolon.handler;
import org.africa.semicolon.Exception.InvalidEmailFoundException;
import org.africa.semicolon.Exception.InvalidPasswordException;
import org.africa.semicolon.Exception.LoginException;
import org.africa.semicolon.Exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<?> handleInvalidPassword(InvalidPasswordException exception){
        return  ResponseEntity.status(BAD_REQUEST)
                .body(Map.of(

                         "error", exception.getMessage(),
                        "success", false
                ));
    }



    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFound(UserNotFoundException exception){
        return ResponseEntity.status(BAD_REQUEST)
                .body(Map.of(
                        "error", exception.getMessage(),
                        "success", false
                ));
    }

    @ExceptionHandler(InvalidEmailFoundException.class)
    public ResponseEntity<?> handleInvalidEmail(InvalidEmailFoundException exception){
        return  ResponseEntity.status(BAD_REQUEST)
                .body(Map.of(

                        "error", exception.getMessage(),
                        "success", false
                ));
    }
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<?> handleLogin(LoginException exception){
        return  ResponseEntity.status(BAD_REQUEST)
                .body(Map.of(

                        "error", exception.getMessage(),
                        "success", false
                ));
    }
}