package com.jldev.mapstructdemo.model

import org.mapstruct.Mapper
import java.math.BigDecimal

@Mapper(componentModel = "spring")
abstract class TransactionMapper {

    fun toTransactionDto(transaction: Transaction): TransactionDto {
        return TransactionDto(
            transaction.uuid,
            transaction.total.multiply(BigDecimal("100")).longValueExact()
        )
    }

    abstract fun toTransactionDto(transactions: Collection<Transaction>): List<TransactionDto>
}