package ru.vood.kotlinredis.domain

data class SomeDto(
    val id: String,
    val dataDecimal: Map<String, Double>,
    val dataString: Map<String, String>,
    val dataBoolean: Map<String, Boolean>,
    val uuid: String,
    val process_timestamp: Long,
) : Identity {
    override fun id(): String = id
}