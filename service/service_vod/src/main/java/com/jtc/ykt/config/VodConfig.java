package com.jtc.ykt.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 小天
 * @Date: 2023/8/23 - 08 - 23 - 16:15
 * @Decsription: com.jtc.ykt.config
 * @version: 1.0
 */
@Configuration
@MapperScan("com.jtc.ykt.vod.mapper")
public class VodConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
