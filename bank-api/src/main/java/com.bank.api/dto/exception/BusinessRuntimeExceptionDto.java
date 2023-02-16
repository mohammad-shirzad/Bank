package com.bank.api.dto.exception;

import lombok.Data;

@Data
public class BusinessRuntimeExceptionDto extends RuntimeException {
    private short errorCode;
    private String errorDescription;
}
