package com.example.springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import com.example.springboot.model.Person;

@Repository("PersonDASerivce")
public class PersonDAService implements PersonDAO {
	private static List<Person> db = new ArrayList<Person>();

	@Override
	public int addPerson(UUID id, Person person) {
		db.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> getAllPeople() {
		return db;
	}

	@Override
	public int deletePerson(UUID id) {
		// Get a person by id
		Optional<Person> person = getPerson(id);
		// If the person exists, delete him/her
		if (person.isPresent()) {
			db.remove(person.get());
			return 1;
		}
		return 0;
	}

	@Override
	public int updatePerson(UUID id, Person person) {
		return getPerson(id).map(p -> {
			// Get the index of a person to update based on the id
			int idxOfPersonToUpdate = db.indexOf(p);
			// If exist, update that person info
			if (idxOfPersonToUpdate >= 0) {
				db.set(idxOfPersonToUpdate, new Person(id, person.getName()));
				return 1;
			}
			return 0;
		}).orElse(0);
	}

	@Override
	public Optional<Person> getPerson(UUID id) {
		return db.stream().filter(person -> person.getId().equals(id)).findFirst();
	}

}
