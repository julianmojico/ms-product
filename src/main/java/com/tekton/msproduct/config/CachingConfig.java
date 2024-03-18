package com.tekton.msproduct.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CachingConfig {

    @Bean
    public static CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("productsStatus");
    }

    @Scheduled(fixedRate = 5L, timeUnit = TimeUnit.MINUTES )
    @CacheEvict(value = "productsStatus", allEntries = true)
    public void clearCache() {
        LoggerConfig.getLogger().info("cleared productsStatus cache");
        CachingConfig.cacheManager().getCache("productsStatus").clear();
    }
}
