package com.brogrammers.kotlin.controllers

import com.brogrammers.kotlin.models.DriverPersona
import com.brogrammers.kotlin.services.DriverService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
class DriverPersonaController(
        var driverService: DriverService
) {


    @GetMapping("/driver/add/{username}")
    fun addDriver(@PathVariable username: String) = driverService.addDriver(DriverPersona(username))

}