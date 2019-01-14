package com.JairoBurgos.DIsplayDate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	
	@RequestMapping("/")
	public String home() {
		return "views/Index.jsp";
	}
	
	@RequestMapping("/date")
	public String date() {
		return "views/dateTemplate.jsp";
	}
	
	@RequestMapping("/time")
	public String time() {
		return "views/timeTemplate.jsp";
	}

}
