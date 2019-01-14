package com.JairoBurgos.Routing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingController {
	
	@RequestMapping("")
	public String test1() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String test2() {
		return "python/django is awesome!";
	}
	
	@RequestMapping("/java")
	public String test3(){
		return "Java is trash";
	}

}
