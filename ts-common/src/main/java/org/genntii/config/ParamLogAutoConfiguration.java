package org.genntii.config;

import org.genntii.handler.ParamLoggerHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/06 11:46
 */
@Configuration
@Import(ParamLoggerHandler.class)
public class ParamLogAutoConfiguration {

}