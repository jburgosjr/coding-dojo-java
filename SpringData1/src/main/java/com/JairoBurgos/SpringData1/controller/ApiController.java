package com.JairoBurgos.SpringData1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JairoBurgos.SpringData1.models.Book;
import com.JairoBurgos.SpringData1.services.ApiService;

@RestController
public class ApiController {
	private final ApiService aS;

	public ApiController(ApiService aS) {
		this.aS = aS;
	}
	
	@RequestMapping("/")
	public List<Book> getAllBooks(){
		return aS.getAllBooks();
	}
	
	
	
	
}
