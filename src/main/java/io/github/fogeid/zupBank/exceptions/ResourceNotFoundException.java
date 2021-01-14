package io.github.fogeid.zupBank.exceptions;

import me.alidg.errors.annotation.ExceptionMapping;
import me.alidg.errors.annotation.ExposeAsArg;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.NOT_FOUND, errorCode = "default.resource_not_found")
public class ResourceNotFoundException extends RuntimeException {

    @ExposeAsArg(0) private final Long id;

    public ResourceNotFoundException(Long id) {
        super("default.resource_not_found " + id);
        this.id = id;
    }
}