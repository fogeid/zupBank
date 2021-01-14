package io.github.fogeid.zupBank.exceptions;

import me.alidg.errors.annotation.ExceptionMapping;
import me.alidg.errors.annotation.ExposeAsArg;
import org.springframework.http.HttpStatus;

@ExceptionMapping(statusCode = HttpStatus.BAD_REQUEST, errorCode = "cpf.already_exists")
public class CpfAlreadyExistsException extends RuntimeException {

    @ExposeAsArg(0) private final String cpf;

    public CpfAlreadyExistsException(String cpf) {
        super("cpf.already_exists " + cpf);
        this.cpf = cpf;
    }
}