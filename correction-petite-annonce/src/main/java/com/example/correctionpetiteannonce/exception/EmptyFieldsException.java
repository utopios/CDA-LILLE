package com.example.correctionpetiteannonce.exception;

public class EmptyFieldsException extends Exception {
    public EmptyFieldsException(String message) {
        super(message);
    }

    public static EmptyFieldsException with(String... fields) {
        String message = "Need Fields : ";
        for(String f : fields) {
            message += f + " ";
        }

        return new EmptyFieldsException(message);
    }

}
