package com.brogrammers.kotlin.config

import com.brogrammers.kotlin.models.DriverPersona
import org.apache.kafka.clients.producer.ProducerConfig.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


@Configuration
class KafkaConfig {

    @Bean
    fun producerFactory(): ProducerFactory<String, DriverPersona> {
        val config: MutableMap<String, Any> = HashMap()
        config.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        config.put(KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, "com.brogrammers.kotlin.common.serializers.DriverSerializer")
        return DefaultKafkaProducerFactory(config)
    }

    @Bean
    @Autowired
    fun kafkaTemplate(producerFactory: ProducerFactory<String, DriverPersona>) = KafkaTemplate(producerFactory)
}