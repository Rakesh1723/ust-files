package com.bookstoreapp.controller;

import com.bookstoreapp.model.Book;
import com.bookstoreapp.service.BookstoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    // GET : /books
    // Return Response code of 200
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return  bookstoreService.getAllBooks();
    }


    // POST : /books
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public Book saveBook(@RequestBody @Valid  Book book) {
        return bookstoreService.saveBook(book);
    }

    // create a PUT request to update a book
    // Return Response code of 202

   // PUT: /books/{id}
    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book updateBook(@PathVariable int id,@RequestBody @Valid Book book) {
         return bookstoreService.updateBook(id,book);
    }

    // create a DELETE request to delete a book
    // Return Response code of 204

    // DELETE : /books/{id}
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable int id) {
        bookstoreService.deleteBook(id);
    }


    // create a GET request to get a book by id
    // Return Response code of 200

    // GET: /books/{id}
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
       return bookstoreService.getBookById(id);
    }

}
