package com.JairoBurgos.QueriesJoins.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.QueriesJoins.models.City;

@Repository
public interface CityRepo extends CrudRepository<City,Long> {

}
