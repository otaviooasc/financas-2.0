package com.projeto.financeiro.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoFoiEncontradoException extends RuntimeException {
    public NaoFoiEncontradoException(String message) {
        super(message);
    }
}
