package com.example.demorest.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

  private LocalDateTime localDateTime;

  private String message;

  private String details;

    public ErrorDetails(LocalDateTime localDateTime, String message, String details) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
