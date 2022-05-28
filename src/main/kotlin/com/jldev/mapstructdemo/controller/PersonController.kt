package com.jldev.mapstructdemo.controller

import com.jldev.mapstructdemo.model.Person
import com.jldev.mapstructdemo.model.PersonDto
import com.jldev.mapstructdemo.model.PersonMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController(
    val mapper: PersonMapper
) {
    @PostMapping("/model")
    fun getPersonModel(@RequestBody personDto: PersonDto) : Person {
        return mapper.mapToModel(personDto)
    }

    @PostMapping("/dto")
    fun getPersonDto(@RequestBody person: Person) : PersonDto {
        return mapper.mapToDto(person)
    }

}