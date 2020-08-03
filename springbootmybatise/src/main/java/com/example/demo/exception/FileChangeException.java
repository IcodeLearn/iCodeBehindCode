package com.example.demo.exception;

public class FileChangeException extends Exception {

    private String message;

    public FileChangeException(String message) {
        super(message);
    }
}
