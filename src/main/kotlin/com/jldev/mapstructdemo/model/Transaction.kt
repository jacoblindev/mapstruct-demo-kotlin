package com.jldev.mapstructdemo.model

import java.math.BigDecimal
import java.util.UUID

data class Transaction(
    val id: Long,
    val uuid: String = UUID.randomUUID().toString(),
    val total: BigDecimal,
)
