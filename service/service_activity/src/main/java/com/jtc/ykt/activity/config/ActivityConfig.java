package com.jtc.ykt.activity.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 小天
 * @Date: 2023/8/31 - 08 - 31 - 14:51
 * @Decsription: com.jtc.ykt.activity.config
 * @version: 1.0
 */
@Configuration
@MapperScan("com.jtc.ykt.activity.mapper")
public class ActivityConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
