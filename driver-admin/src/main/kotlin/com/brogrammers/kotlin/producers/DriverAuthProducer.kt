package com.brogrammers.kotlin.producers

import com.brogrammers.kotlin.models.DriverAuth
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class DriverAuthProducer(val kafkaTemplate: KafkaTemplate<String, DriverAuth>) {



}