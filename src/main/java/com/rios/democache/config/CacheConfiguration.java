package com.rios.democache.config;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.spring.cache.HazelcastCacheManager;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@Configuration
public class CacheConfiguration {
    
    @Bean
    CacheManager cacheManager() {
        return new HazelcastCacheManager(Hazelcast.newHazelcastInstance());
    }
}