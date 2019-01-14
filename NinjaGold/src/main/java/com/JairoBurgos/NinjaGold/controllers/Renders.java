package com.JairoBurgos.NinjaGold.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Renders {

	@RequestMapping("/")
	public String ninjaGold(HttpSession session){
		if(session.isNew()) {
			ArrayList<String> logList = new ArrayList<String>();
			session.setAttribute("gold", 0);
			session.setAttribute("eventLog",logList);
		}
		return "views/NinjaGold.jsp";
	}
}
