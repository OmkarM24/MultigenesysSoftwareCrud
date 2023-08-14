package com.example.MultigenesysSoftwareCrud.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MultigenesysSoftwareCrud.Entity.Bookstore;
import com.example.MultigenesysSoftwareCrud.Service.BookstoreService;

@RestController
@RequestMapping("/api/books")
public class BookstoreController {

	@Autowired
	BookstoreService bookstoreService;
	
	@GetMapping("/list")
	public List<Bookstore> getAllBooks() {
		return bookstoreService.getAllBooks();
	}
	
	@PostMapping("/save")
	public String saveBook(@RequestBody Bookstore bookstore) {
		return bookstoreService.saveBook(bookstore);
	}
	
	@GetMapping("/getbyid/{Id}")
	public Bookstore getbookbyId(@PathVariable Long Id) {
		return bookstoreService.getbookbyId(Id);
	}
	
	@PutMapping("/update/{Id}")
	public String updateBook(@RequestBody Bookstore bookstore,@PathVariable Long Id) {
		return bookstoreService.updateBook(bookstore, Id);
	}
	
	@DeleteMapping("/delete/{Id}")
	public String deleteBook(@PathVariable Long Id) {
		return bookstoreService.deleteBook(Id);
	}
	
	@GetMapping("/by-resource/{resource}")
	public Bookstore getbookbyResource(@PathVariable String resource) {
		return bookstoreService.getbookbyResource(resource);
	}
}
