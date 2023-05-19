package io.kosmocat.hedera.errors;

import io.kosmocat.hedera.errors.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HederaException extends RuntimeException {

    private ErrorCode errorCode;

}
