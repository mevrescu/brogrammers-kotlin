package com.logistics.driveradmin.producers

import com.logistics.driveradmin.models.DriverPersona
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service


/**
 * this service will publish events about
 */
@Service
class DriverProducer(var kafkaTemplate: KafkaTemplate<String, DriverPersona>) {

    private val DRIVER_PERSONA_TOPIC = "driverPersona"

    fun publishDriverPersona(driver: DriverPersona): String {
        val future = kafkaTemplate.send(DRIVER_PERSONA_TOPIC, driver.username, driver)
        val producerRecord = future.get().producerRecord
        return "topic: ${producerRecord.topic()}," +
                " partition: ${producerRecord.partition()}" +
                " key: ${producerRecord.key()}" +
                " value: ${producerRecord.value()}"
    }

}