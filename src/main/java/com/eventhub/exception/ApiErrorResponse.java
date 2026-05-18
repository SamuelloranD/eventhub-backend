package com.eventhub.exception;

import java.time.OffsetDateTime;
import java.util.List;

public record ApiErrorResponse(
        int status,
        String error,
        String message,
        String path,
        OffsetDateTime timestamp,
        List<String> details
) {
    public ApiErrorResponse(int status, String error, String message, String path, OffsetDateTime timestamp) {
        this(status, error, message, path, timestamp, List.of());
    }
}
