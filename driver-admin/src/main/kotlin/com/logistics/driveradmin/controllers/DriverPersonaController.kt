package com.logistics.driveradmin.controllers

import com.logistics.driveradmin.models.DriverPersona
import com.logistics.driveradmin.services.DriverService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController()
class DriverPersonaController(
        var driverService: DriverService
) {


    @GetMapping("/driver/add/{username}")
    fun addDriver(@PathVariable username: String) =
            driverService.addDriver(DriverPersona(username))

}