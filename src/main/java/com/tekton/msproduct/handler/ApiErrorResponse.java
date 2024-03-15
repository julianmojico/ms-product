package com.tekton.msproduct.handler;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

@Builder
@Value
public class ApiErrorResponse {

    String message;
    List<String> errors;
    HttpStatus status;

    public ApiErrorResponse(String message,  HttpStatus status) {
        this.message = message;
        this.errors = Collections.EMPTY_LIST;
        this.status = status;
    }

    public ApiErrorResponse(String message, List<String> errors,  HttpStatus status) {
        this.message = message;
        this.errors = errors;
        this.status = status;
    }
}
