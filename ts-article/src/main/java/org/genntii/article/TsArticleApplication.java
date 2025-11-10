package org.genntii.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/07 14:55
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"org.genntii.article", "org.genntii.common"})
public class TsArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(TsArticleApplication.class, args);
    }
}
