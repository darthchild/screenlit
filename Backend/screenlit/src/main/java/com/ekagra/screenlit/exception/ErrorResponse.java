package com.ekagra.screenlit.exception;

import java.time.Instant;

public record ErrorResponse(
        String message,
        int status,
        String path,
        Instant timestamp
) {}
