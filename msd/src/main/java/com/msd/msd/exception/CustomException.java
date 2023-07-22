package com.msd.msd.exception;


import com.msd.msd.enums.CustomErrorCode;
import lombok.Getter;


@Getter

public class CustomException extends RuntimeException {

    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getMessage());
        this.code = customErrorCode.getCode();
        this.message = customErrorCode.getMessage();

    }

    private final int code;
    private final String message;
}
