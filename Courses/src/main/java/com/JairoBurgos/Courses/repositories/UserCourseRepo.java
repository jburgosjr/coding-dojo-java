package com.JairoBurgos.Courses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.Courses.models.Course;
import com.JairoBurgos.Courses.models.User;
import com.JairoBurgos.Courses.models.UserCourse;

@Repository
public interface UserCourseRepo extends CrudRepository<UserCourse,Long> {
	UserCourse findByCourseAndUser(Course course, User user);
	List<UserCourse> findByCourseContains(Course course);
}
