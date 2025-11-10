package org.genntii.common.config;

import com.alibaba.fastjson.parser.ParserConfig;
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

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({FastJsonHttpMessageConverter.class})
public class DateTimeFormatAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(HttpMessageConverters.class)
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        // 配置FastJson
        FastJsonConfig config = new FastJsonConfig();

        // 配置序列化设置
        SerializeConfig serializeConfig = new SerializeConfig();
        serializeConfig.put(java.time.LocalDate.class, new LocalDateSerializer());
        serializeConfig.put(java.time.LocalDateTime.class, new LocalDateTimeSerializer());

        // 配置反序列化设置 - 使用 ParserConfig
        ParserConfig parserConfig = new ParserConfig();
        parserConfig.putDeserializer(java.time.LocalDate.class, new LocalDateDeserializer());
        parserConfig.putDeserializer(java.time.LocalDateTime.class, new LocalDateTimeDeserializer());

        config.setSerializeConfig(serializeConfig);
        config.setParserConfig(parserConfig); // 设置反序列化配置

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