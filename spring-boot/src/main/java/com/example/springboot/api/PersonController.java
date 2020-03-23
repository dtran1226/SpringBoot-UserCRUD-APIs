package com.example.springboot.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Person;
import com.example.springboot.service.PersonService;

@RestController
@RequestMapping("api/person")
public class PersonController {
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	public void addPerson(@Valid @NotNull @RequestBody Person person) {
		personService.addPerson(person);
	}

	@GetMapping
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}

	@GetMapping(path = "{id}")
	public Person getPerson(@PathVariable("id") UUID id) {
		return personService.getPerson(id).orElse(null);
	}

	@DeleteMapping(path = "{id}")
	public void deletePerson(@PathVariable("id") UUID id) {
		personService.deletePerson(id);
	}

	@PutMapping(path = "{id}")
	public void updatePerson(@PathVariable UUID id, @Valid @NotNull @RequestBody Person person) {
		personService.updatePerson(id, person);
	}
}