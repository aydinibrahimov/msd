package com.msd.msd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientErrorCode {
    CLIENT_NOT_FOUND(101,"Client with id was not found");

    private final int code;
    private final String message;


}
