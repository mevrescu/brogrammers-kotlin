package com.logistics.driveradmin.producers

import com.logistics.driveradmin.models.DriverAuth
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class DriverAuthProducer(val kafkaTemplate: KafkaTemplate<String, DriverAuth>) {



}