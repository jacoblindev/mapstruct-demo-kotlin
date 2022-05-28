package com.jldev.mapstructdemo.model

import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface EmployeeMapper {

    @Mapping(source = "id", target = "empId")
    @Mapping(source = "name", target = "empName")
    @Mapping(source = "division", target = "empDiv")
    @Mapping(source = "startDate", target = "empStartDate", dateFormat = "dd-MM-yyyy")
    fun mapToDto(employee: Employee) : EmployeeDto

    @InheritInverseConfiguration
    fun mapToModel(employeeDto: EmployeeDto) : Employee

    fun mapToDivisionDto(division: Division) : DivisionDto

    fun mapToDivision(divisionDto: DivisionDto) : Division
}