package com.jldev.mapstructdemo.model

import java.time.LocalDate

data class Person(
    val firstName: String,
    val lastName: String,
    val birthday: LocalDate,
    val email: String,
    val cellPhone: String,
)
