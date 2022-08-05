package com.pineapple.product.service.infra.exception;

public class InvalidJsonException extends RuntimeException {

    public InvalidJsonException(String message, Throwable cause) {
        super(message, cause);
    }


}
