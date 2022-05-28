package com.jldev.mapstructdemo.model

import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface PersonMapper {

    @Mapping(source = "cellPhone", target = "phoneNumber")
    @Mapping(source = "birthday", target = "birthDate")
    @Mapping(source = "id", target = "id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    fun mapToDto(person: Person) : PersonDto

    @InheritInverseConfiguration
    fun mapToModel(personDto: PersonDto) : Person
}