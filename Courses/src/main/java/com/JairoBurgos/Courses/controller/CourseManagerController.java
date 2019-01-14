package com.JairoBurgos.Courses.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JairoBurgos.Courses.models.Course;
import com.JairoBurgos.Courses.models.User;
import com.JairoBurgos.Courses.models.UserCourse;
import com.JairoBurgos.Courses.service.CourseManagerService;
import com.JairoBurgos.Courses.validator.UserValidator;

@Controller
public class CourseManagerController {
	
	private final CourseManagerService cMS;
	private final UserValidator uV;
	
	public CourseManagerController(CourseManagerService cMS, UserValidator uV) {

		this.cMS = cMS;
		this.uV = uV;
	}
	
	@GetMapping("/")
	public String loginRegister(@ModelAttribute("userReg")User register,HttpSession session) {
		if(session.isNew()) {
			session.setAttribute("login", false);
		}
		return"jsp/logReg.jsp";
	}
	
	@PostMapping("/register")
	public String registerProcess(@Valid @ModelAttribute("userReg")User uReg,BindingResult result,RedirectAttributes rA) {
		uV.validate(uReg, result);
		if(result.hasErrors()) {
			return"jsp/logReg.jsp";
		}
		else {
			cMS.registerUser(uReg);
			rA.addFlashAttribute("success","<p class=\"alert alert-success\" role=\"alert\"> Registration Successful! You may now Log in. </p>");
			return"redirect:/";
		}
	}
	
	@PostMapping("/Login")
	public String loginProcess(@RequestParam("email")String email,@RequestParam("password")String password,HttpSession session,RedirectAttributes rA) {
		if(cMS.checkLogin(email, password) == false) {
			rA.addFlashAttribute("error","<p class=\"alert alert-danger text-center\" role=\"alert\"> Invalid Credentials </p>");
			return "redirect:/";
		}
		else {
			session.setAttribute("login", true);
			session.setAttribute("user",cMS.findByEmail(email).getId());
			return"redirect:/home";
			
		}
	}
	
	@GetMapping("/home")
	public String homePage(HttpSession session,Model model) {
		if((boolean)session.getAttribute("login") == true) {
			model.addAttribute("user", cMS.getUserById((Long)session.getAttribute("user")));
			model.addAttribute("courses",cMS.allCourses());
			
			return "jsp/home.jsp";
		}
		else {
			return"redirect:/";
		}
	}
	
	@GetMapping("/courses/new")
	public String addCourse(@ModelAttribute("courses")Course course,HttpSession session) {
		if((boolean)session.getAttribute("login") == true) {
			
			return "jsp/createCourse.jsp";
		}
		else {
			return"redirect:/";
		}
	}
	
	@PostMapping("/courses/new")
	public String processCourse(@Valid @ModelAttribute("courses")Course course,BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			
			return"jsp/createCourse.jsp";
		}
		else {
			course.setUser( cMS.getUserById((Long)session.getAttribute("user")));
			cMS.addCourse(course);
			return"redirect:/home";
		}
	}
	
	@PostMapping("/home/add")
	public String addClass(@ModelAttribute("userCourse")UserCourse userCourse) {
		cMS.joinCourse(userCourse);
		return"redirect:/home";
	}
	
	@GetMapping("courses/{courseId}")
	public String courseInfo(HttpSession session,@PathVariable("courseId")Long cId,Model model) {
		if((boolean)session.getAttribute("login") == true) {
			
			model.addAttribute("course", cMS.findCourseById(cId));
			model.addAttribute("userCheck", cMS.getUserById((Long)session.getAttribute("user")));
			
			
			return "jsp/courseInfo.jsp";
		}
		else {
			return"redirect:/";
		}
	}
	
	@DeleteMapping ("courses/{courseId}")
	public String deleteCourse(@PathVariable("courseId")Long cId,@RequestParam("userId")Long uId) {
		Course course = cMS.findCourseById(cId);
		User user = cMS.getUserById(uId);
		if(course.getUser().getId() == user.getId()) {
			cMS.deleteCourseById(cId);
			return"redirect:/home";
		}
		else {
			return"redirect:/logout";
		}
	}
	
	@DeleteMapping("courses/{courseId}/remove")
	public String cancelJoin(@RequestParam("userId")Long uId,@RequestParam("courseId")Long cId) {
		User user = cMS.getUserById(uId);
		Course course = cMS.findCourseById(cId);
		UserCourse cancel = cMS.findJoinedCourse(course, user);
		cMS.cancelCourseAdd(cancel);;
		return"redirect:/home";
	}
	
	@GetMapping("/courses/{courseId}/edit")
	public String editCourse(@ModelAttribute("course")Course course,@PathVariable("courseId")Long cId,HttpSession session,Model model) {
		if((boolean)session.getAttribute("login") == true) {
			model.addAttribute("course", cMS.findCourseById(cId));
			return "jsp/editCourse.jsp";
		}
		else {
			return"redirect:/";
		}
	}
	
	@PutMapping("/courses/{courseId}/edit")
	public String processEditCourse(@Valid @ModelAttribute("course") Course course,BindingResult result,@PathVariable("courseId")Long cId, HttpSession session,Model model) {
		User user = cMS.getUserById((Long)session.getAttribute("user"));
		if(result.hasErrors()) {
//			model.addAttribute("course", cMS.findCourseById(cId));
			return"jsp/editCourse.jsp";
		}
		else {
			course.setId(cId);
			course.setUser(user);
			cMS.addCourse(course);
			return"redirect:/home";
		}
	}
	
	
	
	
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
	
}
