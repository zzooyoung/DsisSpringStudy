package com.example.thisisspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Response<T> {
    private T data;
    private String message;

    public Response(String message) {
        this.message = message;
    }
}
