package com.example.Api_Rest_JAVA_SpringBoot.exeption;


import com.example.Api_Rest_JAVA_SpringBoot.dto.common.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response<Void>> handleNotFound(
            ResourceNotFoundException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Response<>(
                        false,
                        ex.getMessage(),
                        null
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Void>> handlerGeneric(Exception ex) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new Response<>(
                        false,
                        "Error del servidor",
                        null


                ));
    }
}
