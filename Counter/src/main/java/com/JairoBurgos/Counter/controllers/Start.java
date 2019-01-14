package com.JairoBurgos.Counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Start {
	
	@RequestMapping("/")
	public String welcome(HttpSession session){
		
		if (session.isNew()) {
			session.setAttribute("counter", 0);
		}
		else {
			Integer count = (Integer) session.getAttribute("counter");
			count += 1;
			session.setAttribute("counter", count);
		}
		return "views/welcome.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "views/counter.jsp";
	}

}
