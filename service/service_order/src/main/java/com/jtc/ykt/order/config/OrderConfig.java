package com.jtc.ykt.order.config;

/**
 * @Author: 小天
 * @Date: 2023/8/31 - 08 - 31 - 14:21
 * @Decsription: com.jtc.ykt.order.config
 * @version: 1.0
 */

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
@MapperScan("com.jtc.ykt.order.mapper")
public class OrderConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
