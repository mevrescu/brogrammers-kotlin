package com.logisitics.logisticsprovideradmin.kafka.consumer

import com.logisitics.logisticsprovideradmin.common.deserializers.DriverPersonaDeserializer
import com.logistics.driveradmin.models.DriverPersona
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import java.time.Duration

class DriverPersonaConsumer {


    fun consume() {
        val configs = HashMap<String, Any>()
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092")
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer::class.java)
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, DriverPersonaDeserializer::class.java)
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "logistic-providers")
        
        val kafkaConsumer = KafkaConsumer<String, DriverPersona>(configs)
        val consumerRecords = kafkaConsumer.poll(Duration.ofSeconds(1))
    }

}