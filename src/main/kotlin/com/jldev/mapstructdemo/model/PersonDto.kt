package com.jldev.mapstructdemo.model

import java.time.LocalDate

data class PersonDto(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val birthDate: LocalDate,
    val id: String? = null,
) {
}
