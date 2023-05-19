package io.kosmocat.hedera.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {

    BAD_LOGIN("HED#001", HttpStatus.UNAUTHORIZED, "Login failed"),
    NEW_USER_EMAIL_TAKEN("HED#002", HttpStatus.UNAUTHORIZED, "User already exists for this email"),
    NEW_USER_FIELD_MISSING("HED#003", HttpStatus.BAD_REQUEST, "One mandatory field is missing");

    @Getter
    private final String errorCode;
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String errorMessage;

    ErrorCode(String errorCode, HttpStatus httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

}
