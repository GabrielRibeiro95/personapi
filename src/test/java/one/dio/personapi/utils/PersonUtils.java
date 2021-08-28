package one.dio.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import one.dio.personapi.dto.request.PersonDTO;
import one.dio.personapi.entity.Person;

public class PersonUtils {
	
	private static final String FIRST_NAME = "Gabriel", LAST_NAME = "Ribeiro", CPF_NUMBER = "123.456.789.01";
	private static final long PERSON_ID = 1L;
	private static final LocalDate BIRTH_DATE = LocalDate.of(1995, 4, 26);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder().firstName(FIRST_NAME).lastName(LAST_NAME).cpf(CPF_NUMBER).birthDate("26-04-1995")
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO())).build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder().id(PERSON_ID).firstName(FIRST_NAME).lastName(LAST_NAME).cpf(CPF_NUMBER).birthDate(BIRTH_DATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity())).build();
	}
	
}
