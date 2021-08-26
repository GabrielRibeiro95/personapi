package one.dio.personapi.controller;

import one.dio.personapi.dto.response.MessageResponseDTO;
import one.dio.personapi.dto.request.PersonDTO;
import one.dio.personapi.service.PersonService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	private PersonService personService;
	
	@Autowired
	public PersonController(one.dio.personapi.service.PersonService personService) {
		this.personService = personService;
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}
	
}
