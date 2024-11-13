package com.kaankacan.simple_crud_demo.handler;


import com.kaankacan.simple_crud_demo.dto.ErrorResponseDTO;
import com.kaankacan.simple_crud_demo.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductNotFoundException (ProductNotFoundException ex)
    {
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
            "Product not found!",
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage()
        );
        return new ResponseEntity<>(errorResponseDTO,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationException (MethodArgumentNotValidException ex)
    {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
            .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
            .collect(Collectors.toList());
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO("Validation Failed",
            HttpStatus.BAD_REQUEST.value(),
            errors);
        return new ResponseEntity<>(errorResponseDTO,HttpStatus.BAD_REQUEST);
    }

}
