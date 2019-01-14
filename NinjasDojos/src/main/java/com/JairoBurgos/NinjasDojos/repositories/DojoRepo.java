package com.JairoBurgos.NinjasDojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.JairoBurgos.NinjasDojos.models.Dojo;

public interface DojoRepo extends CrudRepository<Dojo,Long> {
	List<Dojo> findAll();
}
