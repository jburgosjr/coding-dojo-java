package com.JairoBurgos.Courses.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Courses.models.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course,Long> {

}
