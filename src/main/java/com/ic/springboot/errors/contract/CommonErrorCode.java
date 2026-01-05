package com.ic.springboot.errors.contract;

public enum CommonErrorCode implements ErrorCode {
    //    GENERIC ERRORS
    GEN_400,
    GEN_401,
    GEN_403,
    GEN_404,
    GEN_409,
    GEN_500,

    //    VALIDATION ERRORS
    VAL_001,
    VAL_002,

    //    SECURITY ERRORS
    SEC_401,
    SEC_403,

    // SYSTEM ERRORS
    SYS_TIMEOUT,
    SYS_UNAVAILABLE;

    @Override
    public String code() {
        return this.name();
    }
}
