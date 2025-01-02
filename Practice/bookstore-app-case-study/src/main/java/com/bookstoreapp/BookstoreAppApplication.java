package com.bookstoreapp;


import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepositoryImpl;
import com.bookstoreapp.service.BookstoreServiceImpl;

public class BookstoreAppApplication {

	public static void main(String[] args) {

		BookstoreServiceImpl bookstoreService=new BookstoreServiceImpl();
		// Book bk=new Book(70,"potter","",1943,897838968296l,330.0);
		// bookstoreService.saveBook(bk);
		// bookstoreService.updateBook(7,bk);
		// Book bk=bookstoreService.getBookById(8);
		// bookstoreService.deleteBook(70);
		bookstoreService.getAllBooks().forEach(i->System.out.println(i));
	}

}
