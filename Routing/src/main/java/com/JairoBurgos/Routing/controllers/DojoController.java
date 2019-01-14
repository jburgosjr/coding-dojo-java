package com.JairoBurgos.Routing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{text}")
	public String pathVariableTest(@PathVariable("text")String text) {
		if (text.equals("dojo")) {
			return "The Dojo is Awesome!";
		}
		if (text.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		}
		
		if (text.equals("san-jose")) {
			return "San Jose Dojo is the headquarters";
		}
		
		return "";
	}
	
}
