package com.example.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.PersonDAO;
import com.example.springboot.model.Person;

@Service
public class PersonService {
	private final PersonDAO personDAO;

	@Autowired
	public PersonService(@Qualifier("PersonDASerivce") PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public int addPerson(Person person) {
		return personDAO.addPerson(person);
	}

	public List<Person> getAllPeople() {
		return personDAO.getAllPeople();
	}

	public int deletePerson(UUID id) {
		return personDAO.deletePerson(id);
	}

	public int updatePerson(UUID id, Person person) {
		return personDAO.updatePerson(id, person);
	}

	public Optional<Person> getPerson(UUID id) {
		return personDAO.getPerson(id);
	}
}
