package com.JairoBurgos.TheCode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Renders {
	
	@RequestMapping("/")
	public String home() {
		return "views/home.jsp";
	}
	
	@RequestMapping("/code")
	public String code() {
		return "views/code.jsp";
	}

}
