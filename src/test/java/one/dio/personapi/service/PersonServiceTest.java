package one.dio.personapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import one.dio.personapi.dto.request.PersonDTO;
import one.dio.personapi.dto.response.MessageResponseDTO;
import one.dio.personapi.entity.Person;
import one.dio.personapi.repository.PersonRepository;
import one.dio.personapi.utils.PersonUtils;

import static one.dio.personapi.utils.PersonUtils.createFakeDTO;
import static one.dio.personapi.utils.PersonUtils.createFakeEntity;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;
	
	private MessageResponseDTO createExpectedMessageResponse(Long id) {
		return MessageResponseDTO.builder().message("Created person with ID " + id).build();
	}
	
	@Test
	void testGivenPersonDTOThenReturnSaveMessage() {
		PersonDTO personDTO = createFakeDTO();
		Person expectedSavedPerson = createFakeEntity();

		Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(expectedSavedPerson);
		
		MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
		
		MessageResponseDTO successMessage = personService.createPerson(personDTO);
		
		Assertions.assertEquals(expectedSuccessMessage, successMessage);
	}
}
