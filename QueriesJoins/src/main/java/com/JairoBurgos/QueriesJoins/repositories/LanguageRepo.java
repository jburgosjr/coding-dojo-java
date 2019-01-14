package com.JairoBurgos.QueriesJoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.QueriesJoins.models.Language;

@Repository
public interface LanguageRepo extends CrudRepository<Language,Long> {
	
}
