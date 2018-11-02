package com.brogrammers.kotlin.common.serializers

import com.brogrammers.kotlin.models.DriverPersona
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class DriverSerializer : Serializer<DriverPersona> {

    private val jsonMapper: ObjectMapper = ObjectMapper()

    override fun serialize(topic: String, data: DriverPersona?): ByteArray? {
        if (data == null) return null
        return jsonMapper.writeValueAsBytes(data)
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) = Unit
    override fun close() = Unit

}