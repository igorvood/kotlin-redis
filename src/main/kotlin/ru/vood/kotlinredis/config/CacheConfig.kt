package ru.vood.kotlinredis.config

import kotlinx.serialization.json.Json
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair
import org.springframework.data.redis.serializer.RedisSerializer
import ru.vood.kotlinredis.domain.SomeDto

import java.time.Duration

@Configuration
class CacheConfig {

    @Bean
    fun redisCacheManagerBuilderCustomizer(): RedisCacheManagerBuilderCustomizer {
        return RedisCacheManagerBuilderCustomizer { builder: RedisCacheManagerBuilder ->
            builder
                .withCacheConfiguration(
                    "itemCache",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(10))
//                        .serializeValuesWith(someDtoRedisSerializer)
                )
                .withCacheConfiguration(
                    "customerCache",
                    RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(5))
                )
        }
    }

//    @Bean
//    fun cacheConfiguration(someDtoRedisSerializer: SomeDtoRedisSerializer): RedisCacheConfiguration {
//        return RedisCacheConfiguration.defaultCacheConfig()
//            .entryTtl(Duration.ofMinutes(60))
//            .disableCachingNullValues()
//            .serializeValuesWith(SerializationPair.fromSerializer(someDtoRedisSerializer))
//    }
}