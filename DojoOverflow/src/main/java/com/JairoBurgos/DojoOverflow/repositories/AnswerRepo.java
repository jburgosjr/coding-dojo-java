package com.JairoBurgos.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.DojoOverflow.models.Answer;

@Repository
public interface AnswerRepo extends CrudRepository<Answer,Long> {

}
