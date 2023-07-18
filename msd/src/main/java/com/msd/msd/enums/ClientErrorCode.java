package com.msd.msd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientErrorCode {

    UNKNOWN_ERROR(100, "Unknown error"),
    CLIENT_NOT_FOUND(101, "Client with id was not found"),
    NOT_VALID_VALUE(102," would not be null"),
    ACCESS_DENIED(103, " access denied"),
    ;


    private final int code;
    private final String message;


}
