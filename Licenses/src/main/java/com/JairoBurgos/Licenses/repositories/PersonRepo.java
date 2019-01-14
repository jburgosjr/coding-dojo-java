package com.JairoBurgos.Licenses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Licenses.models.Person;

@Repository
public interface PersonRepo extends CrudRepository<Person,Long> {
	List<Person> findAll();
}
