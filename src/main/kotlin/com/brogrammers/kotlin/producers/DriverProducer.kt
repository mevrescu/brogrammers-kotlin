package com.brogrammers.kotlin.producers

import com.brogrammers.kotlin.models.DriverPersona
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class DriverProducer (var kafkaTemplate: KafkaTemplate<String, DriverPersona>){
    
    fun publishDriver(driver: DriverPersona){
        kafkaTemplate.send("registerDriver", driver.username, driver)
    }

}