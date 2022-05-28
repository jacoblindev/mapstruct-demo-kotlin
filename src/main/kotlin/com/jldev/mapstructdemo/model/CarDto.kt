package com.jldev.mapstructdemo.model

data class CarDto(
    val id: Int,
    val name: String,
    var fuelType: CarFuelType,
)
