package com.jldev.mapstructdemo.model

import java.util.Date

data class Employee(
    val id: Int,
    val name: String,
    val division: Division,
    val startDate: Date,
)
