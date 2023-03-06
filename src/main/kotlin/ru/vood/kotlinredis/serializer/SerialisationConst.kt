package ru.vood.kotlinredis.serializer

import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual


object SerialisationConst {

    val sadas = MapSerializer(String.serializer(), DecimalAsStringSerializer)

    val customJson = Json {
        serializersModule = SerializersModule {
            this.contextual(String.serializer())
            contextual(Int.serializer())
            contextual(Float.serializer())
            contextual(Double.serializer())
            contextual(Boolean.serializer())
            contextual(Char.serializer())
            contextual(Byte.serializer())
            contextual(DecimalAsStringSerializer)
            contextual(DecimalMapAsStringSerializer)
        }
    }
}