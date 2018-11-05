package com.logisitics.logisticsprovideradmin.common.deserializers

import com.fasterxml.jackson.databind.ObjectMapper
import com.logistics.driveradmin.models.DriverPersona
import org.apache.kafka.common.serialization.Deserializer

class DriverPersonaDeserializer: Deserializer<DriverPersona>{
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) = Unit
    override fun deserialize(topic: String?, data: ByteArray?): DriverPersona {
        val objectMapper = ObjectMapper()
        return objectMapper.readValue(data, DriverPersona::class.java)
    }

    override fun close() = Unit

}