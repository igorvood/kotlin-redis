package ru.vood.kotlinredis.serializer

import kotlinx.serialization.encodeToString
import org.springframework.data.redis.serializer.RedisSerializer
import org.springframework.stereotype.Service
import ru.vood.kotlinredis.domain.SomeDto

@Service
class SomeDtoRedisSerializer : RedisSerializer<SomeDto> {
    override fun serialize(t: SomeDto?): ByteArray? {
        return SerialisationConst.customJson.encodeToString(t).encodeToByteArray()
    }

    override fun deserialize(bytes: ByteArray?): SomeDto? {
        TODO("Not yet implemented")
    }
}