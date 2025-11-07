package org.genntii.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/07 14:22
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class TsUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(TsUserApplication.class, args);
    }
}
