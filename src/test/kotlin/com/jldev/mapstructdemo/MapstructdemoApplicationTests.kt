package com.jldev.mapstructdemo

import com.jldev.mapstructdemo.model.*
import org.junit.jupiter.api.Test
import org.mapstruct.factory.Mappers
import org.springframework.boot.test.context.SpringBootTest
import java.text.SimpleDateFormat
import java.time.LocalDate

@SpringBootTest
class MapstructdemoApplicationTests {
	companion object {
		const val DATE_FORMAT = "dd-MM-yyyy"
	}
	val personMapper: PersonMapper = Mappers.getMapper(PersonMapper::class.java)
	val empMapper: EmployeeMapper = Mappers.getMapper(EmployeeMapper::class.java)

	@Test
	fun contextLoads() {
	}

	@Test
	fun givenPersonDtoWithInfoToPerson_whenMaps_thenCorrect() {
		val dto = PersonDto(
			"Jacob",
			"Lin",
			"0912345678",
			"jacoblindev@gmail.com",
			LocalDate.of(2000,1,1)
		)
		val model = personMapper.mapToModel(dto)

		assert(dto.firstName == model.firstName)
		assert(dto.lastName == model.lastName)
		assert(dto.email == model.email)
		assert(dto.birthDate == model.birthday)
		assert(dto.phoneNumber == model.cellPhone)
	}

	@Test
	fun givenEmployeeDtoWithInfoToEmployee_whenMaps_thenCorrect() {
		val dto = EmployeeDto(1, "Jacob", DivisionDto(1, "IT"), "01-06-2022")
		val model = empMapper.mapToModel(dto)
		val format = SimpleDateFormat(DATE_FORMAT)

		assert(dto.empId == model.id)
		assert(dto.empName == model.name)
		assert(dto.empDiv.id == model.division.id)
		assert(dto.empDiv.name == model.division.name)
		assert(format.parse(dto.empStartDate) == model.startDate)
	}

}
