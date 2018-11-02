package com.brogrammers.kotlin.producers

import com.brogrammers.kotlin.models.DriverPersona
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class DriverProducer(var kafkaTemplate: KafkaTemplate<String, DriverPersona>) {

    fun publishDriver(driver: DriverPersona): String {
        val future = kafkaTemplate.send("registerDriver", driver.username, driver)
        val producerRecord = future.get().producerRecord
        return "topic: ${producerRecord.topic()}," +
                " partition: ${producerRecord.partition()}" +
                " key: ${producerRecord.key()}" +
                " value: ${producerRecord.value().toString()}"
    }

}