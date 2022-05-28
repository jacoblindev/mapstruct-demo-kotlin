package com.jldev.mapstructdemo.model

data class CarBioDiesel(
    override val id: Int,
    override val name: String,
) : Car(id, name)
