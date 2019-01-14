package com.JairoBurgos.SpringData1.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.JairoBurgos.SpringData1.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long>{
    // this method retrieves all the books from the database
    List<Book> findAll();
    
    
    // this method deletes a book through its id
    void deleteById(Long id);
    
//    Optional<Book> findById(Long id);
    
    
}
