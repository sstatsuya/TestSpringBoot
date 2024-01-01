package com.example.spring.boot.errorHandler;

import com.example.spring.boot.entity.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<APIError> handleProductException(ProductException ex){
        System.out.println("Tien vao day");
        APIError apiError = new APIError(ex.getMessage());
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
    }
}
