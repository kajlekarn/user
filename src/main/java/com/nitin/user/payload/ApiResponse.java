package com.nitin.user.payload;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ApiResponse {
    private boolean status;
    private String message;
    private HttpStatus httpStatus;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
