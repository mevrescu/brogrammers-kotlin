package com.brogrammers.kotlin.services

import com.brogrammers.kotlin.models.DriverPersona
import com.brogrammers.kotlin.producers.DriverProducer
import org.springframework.stereotype.Service

@Service
class DriverService (var driverProducer: DriverProducer){

    fun addDriver(driver: DriverPersona) = driverProducer.publishDriver(driver)

}