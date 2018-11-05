package com.brogrammers.kotlin.config

import com.brogrammers.kotlin.common.serializers.DriverAuthSerializer
import com.brogrammers.kotlin.common.serializers.DriverPersonaSerializer
import com.brogrammers.kotlin.models.DriverAuth
import com.brogrammers.kotlin.models.DriverPersona
import org.apache.kafka.clients.producer.ProducerConfig.*
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory


@Configuration
class KafkaConfig {

    @Bean
    fun personaProducerFactory(): ProducerFactory<String, DriverPersona> {
        val config: MutableMap<String, Any> = HashMap()
        config.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        config.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, DriverPersonaSerializer::class.java)
        return DefaultKafkaProducerFactory<String, DriverPersona>(config)
    }

    @Bean
    fun authProducerFactory(): ProducerFactory<String, DriverAuth> {
        val config: MutableMap<String, Any> = HashMap()
        config.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        config.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
        config.put(VALUE_SERIALIZER_CLASS_CONFIG, DriverAuthSerializer::class.java)
        return DefaultKafkaProducerFactory<String, DriverAuth>(config)
    }



    @Bean
    @Autowired
    fun personakafkaTemplate(producerFactory: ProducerFactory<String, DriverPersona>) = KafkaTemplate(producerFactory)

    @Bean
    @Autowired
    fun authPersonakafkaTemplate(producerFactory: ProducerFactory<String, DriverPersona>) = KafkaTemplate(producerFactory)

}