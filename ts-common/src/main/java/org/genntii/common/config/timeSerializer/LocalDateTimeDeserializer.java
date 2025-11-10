package org.genntii.common.config.timeSerializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import org.genntii.common.constant.DateTimePatternConstant;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/07 17:25
 */
public class LocalDateTimeDeserializer implements ObjectDeserializer {

    public static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateTimePatternConstant.dateTimePattern);

    @Override
    public LocalDateTime deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        String dateStr = parser.parseObject(String.class);
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dateStr, fmt);
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

}
