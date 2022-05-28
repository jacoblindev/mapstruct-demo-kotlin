package com.jldev.mapstructdemo.model

data class CarElectric(
    override val id: Int,
    override val name: String,
) : Car(id, name)
