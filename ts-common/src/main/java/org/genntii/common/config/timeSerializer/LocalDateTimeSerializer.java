package org.genntii.common.config.timeSerializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import org.genntii.common.constant.DateTimePatternConstant;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/07 17:23
 */
public class LocalDateTimeSerializer implements ObjectSerializer {

    public static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateTimePatternConstant.dateTimePattern);

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.out.writeNull();
        } else {
            LocalDateTime dateTime = (LocalDateTime) object;
            serializer.write(dateTime.format(fmt));
        }
    }

}
