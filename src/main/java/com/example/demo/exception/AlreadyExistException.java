package com.example.demo.exception;

public class AlreadyExistException extends Error {

    public AlreadyExistException(String msg) {
        super(msg);
    }
}
