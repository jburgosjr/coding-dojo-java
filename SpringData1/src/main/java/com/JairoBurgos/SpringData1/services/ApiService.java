package com.JairoBurgos.SpringData1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.JairoBurgos.SpringData1.models.Book;
import com.JairoBurgos.SpringData1.repositories.BookRepo;

@Service
public class ApiService {
	private final BookRepo bR;
	
	public ApiService(BookRepo bR) {
		this.bR = bR;
	}
	
	public List<Book> getAllBooks(){
		return bR.findAll();
	}

	
	


	
	
}
