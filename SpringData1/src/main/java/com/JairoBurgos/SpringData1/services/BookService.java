package com.JairoBurgos.SpringData1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.JairoBurgos.SpringData1.models.Book;
import com.JairoBurgos.SpringData1.repositories.BookRepo;

@Service
public class BookService {
	private final BookRepo bR;
	
	public BookService(BookRepo bR) {
		this.bR = bR; 
	}
	
    public List<Book> allBooks() {
        return bR.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bR.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bR.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
	public void deleteBook(Long id) {
		bR.deleteById(id);
	}
	
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book temp = findBook(id);
		if (temp != null) {
			temp.setTitle(title);
			temp.setDescription(desc);
			temp.setLanguage(lang);
			temp.setNumberOfPages(numOfPages);
			bR.save(temp);
			return temp;
		}
		return null;
	}
	
	public void updateBook(Book book) {
		bR.save(book);
	}
		

}
