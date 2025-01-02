package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.repository.BookRepositoryImpl;


import java.util.List;
import java.util.Optional;


public class BookstoreServiceImpl implements BookstoreService{


    private BookRepository bookRepository ;

    public BookstoreServiceImpl() {
       bookRepository=new BookRepositoryImpl();
    }

    @Override
    public List<Book> getAllBooks() {
            return  bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        // check if book exists
        // if book exists return book
        // else throw exception book not found

        return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException("book not found exception"));

    }

    @Override
    public Book saveBook(Book book) {

        // check if book exists
        // if book exists throw exception book already exists
        // else save book

//          if(bookRepository.findAll().stream().anyMatch(i->i.getId()==book.getId())) {
//              throw new BookAlreadyExistsException("Book exists exception");
//          }

          if(bookRepository.findById(book.getId()).isPresent())
              throw new BookAlreadyExistsException("Book exists exception");

        return bookRepository.save(book);

    }

    @Override
    public Book updateBook(int id, Book book) {

        // check if book exists
        // if book exists update book
        // else throw exception book not found

        if (bookRepository.findById(id).isPresent()){
            return  bookRepository.update(book);
    }
        throw new BookNotFoundException("book not found exception");

    }

    @Override
    public void deleteBook(int id) {

            // check if book exists
            // if book exists delete book
            // else throw exception book not found

        if (bookRepository.findById(id).isPresent()){
              bookRepository.deleteById(id);
              return ;
        }
        throw new BookNotFoundException("book not found exception");
    }


}
