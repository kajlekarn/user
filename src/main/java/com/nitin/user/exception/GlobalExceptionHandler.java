package com.nitin.user.exception;

import com.nitin.user.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private ApiResponse apiResponse;

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ApiResponse> noDataFoundExceptionHandler(NoDataFoundException ex) {
        apiResponse.setStatus(false);
        apiResponse.setMessage(ex.getMessage());
        apiResponse.setHttpStatus(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(apiResponse);
    }
}
