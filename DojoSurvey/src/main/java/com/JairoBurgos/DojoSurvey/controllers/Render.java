package com.JairoBurgos.DojoSurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Render {
	
	@RequestMapping("/")
	public String home() {
		return "views/home.jsp";
	}
	
	@RequestMapping("/result")
	public String info() {
		return "views/info.jsp";
	}

}
