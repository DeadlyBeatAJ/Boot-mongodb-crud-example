package com.Deadlybeat.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Deadlybeat.model.Book;
import com.Deadlybeat.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository repository;
	
	//add a book
	@PostMapping("/addBook")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "Added book with ID:-"+book.getId();	
	}
	
	//get all books
	@GetMapping("/FindAllBooks")
	public List<Book> getBooks(){
		return repository.findAll();
	}
	
	//get book by the id
	@GetMapping("/FindBook/{id}")
	public Optional<Book> getBookById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	//Delete book by id
	@DeleteMapping("deleteBook/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);		
		return "Book deleted whose id is:-"+id;
	}
	
	@PutMapping("updateBook/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable int id) {
		
		Book ExistingProduct=repository.findById(id).orElse(null);
		
		ExistingProduct.setId(book.getId());
		ExistingProduct.setBookName(book.getBookName());
		ExistingProduct.setAuthorName(book.getAuthorName());
		
		return repository.save(ExistingProduct);		
	}

	
}
