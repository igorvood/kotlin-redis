package ru.vood.kotlinredis.repo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository
import ru.vood.kotlinredis.domain.SomeDto

interface ISomeRepo {

    fun getSomeData(id: String) : SomeDto
}

@Repository
class SomeRepo : ISomeRepo {

     val logger: Logger = LoggerFactory.getLogger(         SomeRepo::class.java)

    @Cacheable(value = ["itemCache"])
    override fun getSomeData(id: String): SomeDto {
        logger.info("get SomeDto with id $id")
        return SomeDto(
            id,
            mapOf("1" to Double.MIN_VALUE),
            mapOf("2" to "22"),
            mapOf("3" to false),
            "",
            0
        )
    }
}