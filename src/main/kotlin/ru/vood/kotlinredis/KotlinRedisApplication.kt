package ru.vood.kotlinredis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class KotlinRedisApplication

fun main(args: Array<String>) {
    runApplication<KotlinRedisApplication>(*args)
}
