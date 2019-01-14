package com.JairoBurgos.NinjasDojos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.NinjasDojos.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja,Long> {

}
