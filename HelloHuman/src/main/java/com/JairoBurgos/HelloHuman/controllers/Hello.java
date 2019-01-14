package com.JairoBurgos.HelloHuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class Hello {
	@RequestMapping("/")
	public String render1(@RequestParam(value="firstName",required=false, defaultValue="Human")String firstName,@RequestParam(value="lastName", required=false, defaultValue="Humanson")String lastName,Model model) {
		
			model.addAttribute("firstName",firstName);
			model.addAttribute("lastName", lastName);
		
		
		return "/views/hello.jsp";
	}
}
