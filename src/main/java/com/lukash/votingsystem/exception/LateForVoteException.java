package com.lukash.votingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class LateForVoteException extends RuntimeException {

    public LateForVoteException(String message) {
        super(message);
    }
}
