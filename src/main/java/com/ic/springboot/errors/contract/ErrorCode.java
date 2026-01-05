package com.ic.springboot.errors.contract;

public interface ErrorCode {

    String code();

    default Integer httpStatus() {
        return 500;
    }

    default String message() {
        return "An unexpected error occurred.";
    }

}
