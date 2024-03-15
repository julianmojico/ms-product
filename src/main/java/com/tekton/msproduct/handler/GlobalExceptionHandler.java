package com.tekton.msproduct.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNoResourceFoundException(NoResourceFoundException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse("Resource not found", List.of(ex.getMessage()), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ApiErrorResponse> handleGeneralException(HttpRequestMethodNotSupportedException ex, WebRequest request) {
        ApiErrorResponse error = new ApiErrorResponse("Resource not found", List.of(ex.getMessage()), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiErrorResponse> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) throws JsonProcessingException {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        ApiErrorResponse error = new ApiErrorResponse("Resource not found",  errors, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiErrorResponse> handleGeneralException(Exception ex, WebRequest request) {

        ApiErrorResponse error = new ApiErrorResponse("Operation interrupted due to internal server error", List.of(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(error, error.getStatus());
    }
}