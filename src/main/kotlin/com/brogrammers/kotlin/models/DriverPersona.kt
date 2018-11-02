package com.brogrammers.kotlin.models

import java.util.*

data class DriverPersona(
        val username: String,
        var firstName: String = "",
        var lastName: String = "",
        var email: String = "",
        var phoneNumer: String = "",
        var documents: Map<Docs, String> = Collections.emptyMap()
)