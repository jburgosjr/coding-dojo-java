package com.JairoBurgos.Courses.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.JairoBurgos.Courses.models.User;
import com.JairoBurgos.Courses.service.CourseManagerService;


@Component
public class UserValidator implements Validator {
	private CourseManagerService cMS;
	
	

	public UserValidator(CourseManagerService cMS) {
	
		this.cMS = cMS;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		
		
		if(!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
		
		if(cMS.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Registered");
			
		}
		
		
	}
		
}




