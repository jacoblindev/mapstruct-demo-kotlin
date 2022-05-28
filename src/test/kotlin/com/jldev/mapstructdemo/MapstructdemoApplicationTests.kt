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
	val userBodyMapper: UserBodyValuesMapper = Mappers.getMapper(UserBodyValuesMapper::class.java)

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
	fun givenPersonEntityToPersonWithExpression_whenMaps_thenCorrect() {
		val person = Person(
			"Jacob",
			"Lin",
			LocalDate.of(2000,1,1),
			"jacoblindev@gmail.com",
			"0912345678",
		)
		val personDto = personMapper.mapToDto(person)

		assert(person.id == null)
		assert(personDto.id != null)
		assert(person.cellPhone == personDto.phoneNumber)
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

	@Test
	fun givenUserBodyValuesWithImperialToMetric_whenMaps_thenCorrect() {
		val imperialValues = UserBodyValuesImperial(10, 100)
		val metricValues = userBodyMapper.userBodyValuesConverter(imperialValues)

		assert(metricValues != null)
		assert(metricValues.centimeter == 25.4)
		assert(metricValues.kilogram == 45.35)
	}

}
