package com.logistics.driveradmin.services

import com.logistics.driveradmin.models.DriverPersona
import com.logistics.driveradmin.producers.DriverProducer
import org.springframework.stereotype.Service

@Service
class DriverService(var driverPersonaProducer: DriverProducer) {

    fun addDriver(driver: DriverPersona) =
            driverPersonaProducer.publishDriverPersona(driver)

}