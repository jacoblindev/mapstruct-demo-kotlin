package com.jldev.mapstructdemo.model

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.MappingTarget

@Mapper
interface CustomerMapper {
    @Mapping(source = "firstName", target = "forename")
    @Mapping(source = "lastName", target = "surname")
    fun from(customer: Customer) : CustomerDto

    @Mapping(source = "customer.firstName", target = "forename")
    @Mapping(source = "customer.lastName", target = "surname")
    @Mapping(source = "customerAddress.street", target = "street")
    @Mapping(source = "customerAddress.postalCode", target = "postalCode")
    @Mapping(source = "customerAddress.county", target = "county")
    fun toDeliveryAddress(customer: Customer, customerAddress: CustomerAddress): CustomerDeliveryAddress

    @Mapping(source = "address.street", target = "street")
    @Mapping(source = "address.postalCode", target = "postalCode")
    @Mapping(source = "address.county", target = "county")
    fun updateDeliveryAddress(
        @MappingTarget deliveryAddress: CustomerDeliveryAddress,
        address: CustomerAddress
    ): CustomerDeliveryAddress
}