package org.genntii.exception;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/06 11:30
 */
public class BaseException extends RuntimeException {

    public static final int DEFAULT_ERROR_STATUS_CODE = 500;

    private int code;

    public BaseException(String message) {
        super(message);
        this.code = DEFAULT_ERROR_STATUS_CODE;
    }

    public BaseException(String message, int code) {
        super(message);
        this.code = code;
    }

    public BaseException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public BaseException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }
}
