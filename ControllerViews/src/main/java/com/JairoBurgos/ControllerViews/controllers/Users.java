package com.JairoBurgos.ControllerViews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JairoBurgos.ControllerViews.models.User;
import com.JairoBurgos.ControllerViews.services.UserService;

@Controller
public class Users {
    private final UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // if result has errors, return the registration page (don't worry about validations just now)
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	if(result.hasErrors()) {
    		return"registrationPage.jsp";
    	}
    	else if(!user.getPasswordConfirmation().equals(user.getPassword())) {
    		return"redirect:/registration";
    	}
    	else {
    		userService.registerUser(user);
    		return"redirect:/login";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes rA) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(userService.authenticateUser(email, password) == false) {
    		String error = "Invalid Credentials";
    		rA.addFlashAttribute("error",error);
    		return"redirect:/login";
    	}
    	else {
    		User userInfo = userService.findByEmail(email);
    		
    		session.setAttribute("info", userInfo.getId());
    		
    		return"redirect:/home";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	
    	model.addAttribute("user",userService.findUserById((Long)session.getAttribute("info")));
    	return"homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return"redirect:/login";
    }
}