package com.JairoBurgos.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.DojoOverflow.models.TagQuestion;

@Repository
public interface TagQuestionRepo extends CrudRepository<TagQuestion,Long> {

}
