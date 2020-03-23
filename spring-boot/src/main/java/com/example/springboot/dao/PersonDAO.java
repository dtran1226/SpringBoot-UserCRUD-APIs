package com.example.springboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.springboot.model.Person;

public interface PersonDAO {
	int addPerson(UUID id, Person person);

	default int addPerson(Person person) {
		UUID id = UUID.randomUUID();
		return addPerson(id, person);
	}

	List<Person> getAllPeople();

	int deletePerson(UUID id);

	int updatePerson(UUID id, Person person);
	
	Optional<Person> getPerson(UUID id);
}
