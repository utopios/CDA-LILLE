package com.example.correctionpetiteannonce.exception;

public class UserNotExistException extends Exception{
    public UserNotExistException() {
        super("User Not Exist");
    }
}
