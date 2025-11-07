package org.genntii.common.config.timeSerializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import org.genntii.common.constant.DateTimePatternConstant;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/07 17:14
 */
public class LocalDateSerializer implements ObjectSerializer {

    public static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(DateTimePatternConstant.datePattern);

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        if (object == null) {
            serializer.out.writeNull();
        } else {
            LocalDate date = (LocalDate) object;
            serializer.write(date.format(fmt));
        }
    }
}
