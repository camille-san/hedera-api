package io.kosmocat.hedera.restcontrollers;

import io.kosmocat.hedera.errors.ErrorCode;
import io.kosmocat.hedera.errors.HederaException;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {HederaException.class})
    protected ResponseEntity<Object> handleError(HederaException ex, WebRequest request) {
        return new ResponseEntity<>(new Error(ex.getErrorCode()), ex.getErrorCode().getHttpStatus());
    }
}

@Getter
class Error {

    private String errorCode;
    private String errorMessage;

    public Error(ErrorCode errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }

}