package com.jtc.ykt.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 小天
 * @Date: 2023/9/4 - 09 - 04 - 15:12
 * @Decsription: com.jtc.ykt.user
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cpm.jtc.ykt.user.mapper")
public class ServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }

}
