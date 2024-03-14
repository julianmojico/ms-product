package com.tekton.msproduct.handler;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

@Builder
@Value
public class ApiErrorResponse {

    String message;
    String code;
    HttpStatus status;
}
