package com.techeer3rd.freelogbackend.global.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final String message;

    public BaseException(String message) {
        super(message);
        this.message = message;
    }
}