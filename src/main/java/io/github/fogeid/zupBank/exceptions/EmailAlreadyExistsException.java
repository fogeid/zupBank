package io.github.fogeid.zupBank.exceptions;

import me.alidg.errors.annotation.ExceptionMapping;
import me.alidg.errors.annotation.ExposeAsArg;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.BAD_REQUEST, errorCode = "email.already_exists")
public class EmailAlreadyExistsException extends RuntimeException {
    @ExposeAsArg(0) private final String email;

    public EmailAlreadyExistsException(String email) {
        super("email.already_exists " + email);
        this.email = email;
    }
}