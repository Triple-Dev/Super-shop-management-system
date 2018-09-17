package com.example.demo.exception;

public class DoesNotExists extends Error {
    public DoesNotExists(String msg) {
        super(msg);
    }
}
