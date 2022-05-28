package com.jldev.mapstructdemo.model

data class CustomerDeliveryAddress(
    val forename: String,
    val surname: String,
    var street: String,
    var postalCode: String,
    var county: String,
)
