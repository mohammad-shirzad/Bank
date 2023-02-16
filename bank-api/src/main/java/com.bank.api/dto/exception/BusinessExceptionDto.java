package com.bank.api.dto.exception;

public class BusinessExceptionDto extends Exception {
    private String errorCode;
    private String errorDescription;

    public BusinessExceptionDto() {
    }

    public BusinessExceptionDto(String message) {
        super(message);
    }

    public BusinessExceptionDto(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessExceptionDto(Throwable cause) {
        super(cause);
    }

    public BusinessExceptionDto(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BusinessExceptionDto(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public BusinessExceptionDto(String message, String errorCode, String errorDescription) {
        super(message);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public BusinessExceptionDto(String message, Throwable cause, String errorCode, String errorDescription) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public BusinessExceptionDto(Throwable cause, String errorCode, String errorDescription) {
        super(cause);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public BusinessExceptionDto(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode, String errorDescription) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "BusinessExceptionDto{" +
                "errorCode='" + errorCode + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
