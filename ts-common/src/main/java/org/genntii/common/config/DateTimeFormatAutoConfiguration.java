package org.genntii.common.config;

import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.genntii.common.config.timeSerializer.LocalDateDeserializer;
import org.genntii.common.config.timeSerializer.LocalDateSerializer;
import org.genntii.common.config.timeSerializer.LocalDateTimeDeserializer;
import org.genntii.common.config.timeSerializer.LocalDateTimeSerializer;
import org.genntii.common.constant.DateTimePatternConstant;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/07 17:28
 */
@Configuration
@ConditionalOnWebApplication // 仅在Web应用环境下生效
@ConditionalOnClass({FastJsonHttpMessageConverter.class}) // 确保FastJson在类路径下
public class DateTimeFormatAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(HttpMessageConverters.class) // 避免重复配置
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        // 配置FastJson
        FastJsonConfig config = new FastJsonConfig();

        // 配置序列化设置
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(java.time.LocalDate.class, new LocalDateSerializer());
        serializeConfig.put(java.time.LocalDateTime.class, new LocalDateTimeSerializer());
        // 配置反序列化（Fastjson 1.2.83 及以后版本）
        serializeConfig.put(java.time.LocalDate.class, new LocalDateDeserializer());
        serializeConfig.put(java.time.LocalDateTime.class, new LocalDateTimeDeserializer());

        config.setSerializeConfig(serializeConfig);
        config.setSerializerFeatures(
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.DisableCircularReferenceDetect
        );
        config.setDateFormat(DateTimePatternConstant.dateTimePattern);

        converter.setFastJsonConfig(config);

        // 支持多种MediaType
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(mediaTypes);

        return new HttpMessageConverters(converter);
    }
}