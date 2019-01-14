package com.JairoBurgos.SpringBootTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class index {
	@RequestMapping("/")
	public String index2(@RequestParam(value="firstName")String name, Model model) {
		model.addAttribute("name",name);
		System.out.println(name);
		return "test.jsp";
	}
	
	@RequestMapping("/users/{id}")
	public String index3(@PathVariable("id")Long id) {
		
		System.out.println(id);
		return "test.jsp";
	}
}
