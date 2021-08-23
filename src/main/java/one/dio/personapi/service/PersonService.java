package one.dio.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.dio.personapi.dto.MessageResponseDTO;
import one.dio.personapi.entity.Person;
import one.dio.personapi.repository.PersonRepository;

@Service
public class PersonService {
	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();
	}
}
