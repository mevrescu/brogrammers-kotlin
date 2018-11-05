package com.brogrammers.kotlin.common.serializers

import com.brogrammers.kotlin.models.DriverAuth
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class DriverAuthSerializer : Serializer<DriverAuth> {

    private val jsonMapper: ObjectMapper = ObjectMapper()

    override fun serialize(topic: String, data: DriverAuth?): ByteArray? {
        if (data == null) return null
        return jsonMapper.writeValueAsBytes(data)
    }

    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) = Unit
    override fun close() = Unit

}