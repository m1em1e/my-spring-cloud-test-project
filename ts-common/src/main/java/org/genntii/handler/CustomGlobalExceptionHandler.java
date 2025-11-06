package org.genntii.handler;

import lombok.extern.slf4j.Slf4j;
import org.genntii.Util.Result;
import org.genntii.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/06 11:16
 */
@Slf4j
@RestControllerAdvice
public class CustomGlobalExceptionHandler {

    @ExceptionHandler
    public Result exceptionHandler(BaseException exception) {
        log.error("异常信息：{}", exception.getMessage());
        return Result.error(exception.getMessage());
    }

}
