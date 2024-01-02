package com.example.thisisspring.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    COFFEE_BEAN_DATA_NOT_FOUND(HttpStatus.NO_CONTENT, "커피 빈 데이터를 찾을 수 업습니다.");

    private final HttpStatus status;
    private final String errorMessage;

    ErrorCode(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
