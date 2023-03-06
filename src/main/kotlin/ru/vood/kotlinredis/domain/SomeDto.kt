package ru.vood.kotlinredis.domain

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import org.springframework.data.redis.serializer.RedisSerializer
import ru.vood.kotlinredis.serializer.SerialisationConst

@Serializable
data class SomeDto(
    val id: String,
    val dataDecimal: Map<String, Double>,
    val dataString: Map<String, String>,
    val dataBoolean: Map<String, Boolean>,
    val uuid: String,
    val process_timestamp: Long,
) : Identity, java.io.Serializable {
    override fun id(): String = id

    companion object {
        val redisSerializer = object: RedisSerializer<SomeDto> {
            override fun serialize(t: SomeDto?): ByteArray = SerialisationConst.customJson.encodeToString(t).encodeToByteArray()

            override fun deserialize(bytes: ByteArray?): SomeDto? {
                return if (bytes == null)
                    null
                else {
                    SerialisationConst.customJson.decodeFromString(serializer(), String(bytes))
                }
            }
        }

    }
}

