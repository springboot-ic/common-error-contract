package com.ic.springboot.errors.contract;

public record ErrorDetail(
        String field,
        String message,
        String code
) {
}
