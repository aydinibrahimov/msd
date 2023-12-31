package com.msd.msd.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CustomErrorCode {

    UNKNOWN_ERROR(100, "Unknown error"),
    CLIENT_NOT_FOUND(101, "Client with id was not found"),
    NOT_VALID_VALUE(102, " would not be null"),
    ACCESS_DENIED(103, " access denied"),
    CONTACT_NOT_FOUND(104, "Contact with id was not found"),
    PRODUCT_NOT_FOUND(105, "Product with id was not found"),
    VENDOR_NOT_FOUND(106, "Vendor with id was not found"),

    ;


    private final int code;
    private final String message;


}
