package one.dio.personapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@GetMapping
	public String getBook() {
		return "API funcionando!";
	}
	
}
