package com.JairoBurgos.QueriesJoins.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.JairoBurgos.QueriesJoins.services.ApiService;

@Controller
public class QJController {
	private final ApiService ApiService;
	
	
	public QJController(com.JairoBurgos.QueriesJoins.services.ApiService apiService) {
		ApiService = apiService;
	}


	@RequestMapping("/")
	public String index(Model model) {
		List<Object[]> question1 = ApiService.question1("slovene");
		model.addAttribute("list",question1);
	
		return "jsp/index.jsp";
	}
}
