package com.example.springboot.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.springboot.model.Person;

@Repository("PersonDASerivce2")
public class PersonDAService2 implements PersonDAO {

	@Override
	public int addPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> getAllPeople() {
		return Arrays.asList(new Person(UUID.randomUUID(), "Service 2"));
	}

	@Override
	public int deletePerson(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Person> getPerson(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
