package com.JairoBurgos.Courses.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.JairoBurgos.Courses.models.Course;
import com.JairoBurgos.Courses.models.User;
import com.JairoBurgos.Courses.models.UserCourse;
import com.JairoBurgos.Courses.repositories.CourseRepo;
import com.JairoBurgos.Courses.repositories.UserCourseRepo;
import com.JairoBurgos.Courses.repositories.UserRepo;

@Service
public class CourseManagerService {
	
	private final UserRepo uR;
	private final CourseRepo cR;
	private final UserCourseRepo uCR;
	
	public CourseManagerService(UserRepo uR, CourseRepo cR, UserCourseRepo uCR) {
		this.uR = uR;
		this.cR = cR;
		this.uCR = uCR;
	}
	
	public User findByEmail(String email) {
		return uR.findByEmail(email);
	}
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return uR.save(user);
	}
	
	public boolean checkLogin(String email,String password) {
		User user = uR.findByEmail(email);
		if(user == null) {
			return false;
		}
		else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public User getUserById(Long id) {
		return uR.findById(id).get();
	}
	
	public Course addCourse(Course course) {
		return cR.save(course);
	}
	
	public UserCourse joinCourse(UserCourse userCourse) {
		return uCR.save(userCourse);
	}
	
	public Iterable<Course> allCourses(){
		return cR.findAll();
	}
	
	public Course findCourseById(Long id) {
		 if (cR.findById(id).isPresent()) {
			 return cR.findById(id).get();
		 }
		 else {
			 return null;
		 }
	}
	
	public void deleteCourseById(Long id) {
		cR.deleteById(id);
	}
	
	public UserCourse findJoinedCourse(Course course, User user) {
		return uCR.findByCourseAndUser(course, user);
	}
	
	public void cancelCourseAdd(UserCourse userCourse) {
		uCR.delete(userCourse);
	}
	

	


	
}
