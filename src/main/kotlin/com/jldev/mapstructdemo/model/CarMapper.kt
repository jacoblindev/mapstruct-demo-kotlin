package com.jldev.mapstructdemo.model

import org.mapstruct.AfterMapping
import org.mapstruct.BeforeMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class CarMapper {
    @BeforeMapping
    fun enrichDTOWithFuelType(car: Car, @MappingTarget carDto: CarDto) {
        if (car is CarElectric)
            carDto.fuelType = CarFuelType.ELECTRIC

        if (car is CarBioDiesel)
            carDto.fuelType = CarFuelType.BIO_DIESEL
    }

    @AfterMapping
    fun convertNameToUpperCase(@MappingTarget carDto: CarDto) {
        carDto.name.uppercase()
    }

    abstract fun toCarDto(car: Car) : CarDto
}