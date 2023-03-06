package ru.vood.kotlinredis.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.math.BigDecimal

object DecimalMapAsStringSerializer : KSerializer<Map<String, BigDecimal>> {


    val mapSerializer = MapSerializer(String.serializer(), DecimalAsStringSerializer)

    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("decimalStringMap", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): Map<String, BigDecimal> {
        val deserialize = mapSerializer.deserialize(decoder)
        return deserialize
    }

    override fun serialize(encoder: Encoder, value: Map<String, BigDecimal>) {
        mapSerializer.serialize(encoder, value)
    }

}