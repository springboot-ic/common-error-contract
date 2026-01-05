package com.ic.springboot.errors.contract;

import java.time.Instant;
import java.util.List;

public record ApiError(
        ErrorCode code,
        String message,
        ErrorCategory category,
        String service,
        String traceId,
        Instant timestamp,
        List<ErrorDetail> errors   // OPTIONAL
) {
}
