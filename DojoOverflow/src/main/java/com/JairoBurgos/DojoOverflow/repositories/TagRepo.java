package com.JairoBurgos.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.DojoOverflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag,Long> {
	Tag findBySubjectIgnoreCase(String subject);
}
