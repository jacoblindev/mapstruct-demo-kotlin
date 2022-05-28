package com.jldev.mapstructdemo.model

data class EmployeeDto(
    val empId: Int,
    val empName: String,
    val empDiv: DivisionDto,
    val empStartDate: String,
)
