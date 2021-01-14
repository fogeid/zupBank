package io.github.fogeid.zupBank.exceptions;

import org.springframework.http.HttpStatus;

import me.alidg.errors.annotation.ExceptionMapping;

@ExceptionMapping(statusCode = HttpStatus.NOT_FOUND, errorCode = "default.cpf_required")
public class CpfErrorException extends RuntimeException {
    public CpfErrorException(String message) {
        super(message);
    }
}