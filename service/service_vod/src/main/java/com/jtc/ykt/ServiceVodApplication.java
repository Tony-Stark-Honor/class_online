package com.jtc.ykt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: 小天
 * @Date: 2023/8/23 - 08 - 23 - 15:29
 * @Decsription: com.jtc
 * @version: 1.0
 */
@SpringBootApplication
@ComponentScan("com.jtc")
@EnableDiscoveryClient
public class ServiceVodApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceVodApplication.class, args);
    }
}
