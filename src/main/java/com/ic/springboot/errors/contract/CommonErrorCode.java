package com.ic.springboot.errors.contract;

public enum CommonErrorCode implements ErrorCode {

    // GENERIC ERRORS
    GEN_400(400, "Bad request"),
    GEN_401(401, "Unauthorized"),
    GEN_403(403, "Forbidden"),
    GEN_404(404, "Resource not found"),
    GEN_409(409, "Conflict"),
    GEN_500(500, "Internal server error"),

    // VALIDATION ERRORS
    VAL_001(400, "Validation failed"),
    VAL_002(400, "Invalid input"),

    // SECURITY ERRORS
    SEC_401(401, "Authentication required"),
    SEC_403(403, "Access denied"),

    // SYSTEM ERRORS
    SYS_TIMEOUT(504, "System timeout"),
    SYS_UNAVAILABLE(503, "Service unavailable");

    private final int httpStatus;
    private final String message;

    CommonErrorCode(int httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String code() {
        return name();
    }

    @Override
    public Integer httpStatus() {
        return httpStatus;
    }

    @Override
    public String message() {
        return message;
    }
}
