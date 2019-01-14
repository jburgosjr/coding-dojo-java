package com.JairoBurgos.Events.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.JairoBurgos.Events.models.User;
import com.JairoBurgos.Events.services.ProjectService;


@Component
public class UserValidator implements Validator{
	private ProjectService pS;

	public UserValidator(ProjectService pS) {
		this.pS = pS;
		
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		
		
		if(!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		}
		
		if(pS.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Registered");
			
		}
		
		
	}


	
}
