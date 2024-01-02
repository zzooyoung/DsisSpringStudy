package com.example.thisisspring.exception;


import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String status;
    private final String errorMessage;

    // ErrorCode 생성자
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
        this.status = errorCode.getStatus().toString();
        this.errorMessage = errorCode.getErrorMessage();
    }
}
