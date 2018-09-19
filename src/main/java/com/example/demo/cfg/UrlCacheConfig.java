package com.example.demo.cfg;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @program: Druid
 * @description:
 * @author: ChenYu
 * @create: 2018-09-19 16:56
 **/
@Configuration
public class UrlCacheConfig {
    @Bean
    public Cache<String, Integer> getCache() {
        // 缓存有效期为2秒
        return CacheBuilder.newBuilder().expireAfterWrite(2L, TimeUnit.SECONDS).build();
    }
}
