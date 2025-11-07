package org.genntii.common.config.timeSerializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import org.genntii.common.constant.DateTimePatternConstant;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/07 17:17
 */
public class LocalDateDeserializer implements ObjectDeserializer {

    public static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateTimePatternConstant.datePattern);

    @Override
    public LocalDate deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        String dateStr = parser.parseObject(String.class);
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        return LocalDate.parse(dateStr, fmt);
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

}
