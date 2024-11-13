package com.kaankacan.simple_crud_demo.dto;

import java.time.LocalDateTime;

public class ErrorResponseDTO <T> {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private T errors;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public T getErrors() {
        return errors;
    }

    public void setErrors(T errors) {
        this.errors = errors;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    public ErrorResponseDTO(String message, int status, T errors) {
        this.message = message;
        this.status = status;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();

    }


}
