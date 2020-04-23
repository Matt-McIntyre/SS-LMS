package com.ss.lms.unitTests;

import org.junit.Test;

import com.ss.lms.dao.AuthorService;
import com.ss.lms.dao.BookService;
import com.ss.lms.dao.PublisherService;
import com.ss.lms.models.Author;
import com.ss.lms.models.Book;
import com.ss.lms.models.Publisher;

public class TestApp {

	@Test
	public final void test() {
		try {
		AuthorService authDao = new AuthorService();
		PublisherService pubDao = new PublisherService();
		BookService bookDao = new BookService(authDao.getAuthorMap(), pubDao.getPublisherMap());
		authDao.setBookMap(bookDao.getBookMap());
		pubDao.setBookMap(bookDao.getBookMap());		
		
		//Loaded by singleton class DataFileIO
		authDao.loadData();				
		pubDao.loadData();		
		bookDao.loadData();
		
		System.out.println("CREATE");
		//CREATE takes object parameter (constructor overloaded to handle w or w/o id parameter)
		//KeyGen singleton object generates unique key when Id not passed
		authDao.create(new Author(10, "Example Author 1"));
		authDao.create(new Author("Example Author 2"));
		pubDao.create(new Publisher(10, "Example Publisher", "5555 Example"));
		bookDao.create(new Book("Example Book", authDao.getAuthorMap().get(10), pubDao.getPublisherMap().get(10)));
		
		System.out.println("READ");
		
		//READ Returns List object
		authDao.read().forEach(e -> System.out.println(e.toString()));
		pubDao.read().forEach(e -> System.out.println(e.toString()));
		bookDao.read().forEach(e -> System.out.println(e.toString()));
		
		System.out.println("\n\nREAD AFTER UPDATE");
		
		//UPDATE takes Id and new values
		authDao.update(10, "Updated Example Author");
		authDao.read().forEach(e -> System.out.println(e.toString()));
		bookDao.read().forEach(e -> System.out.println(e.toString()));
		
		System.out.println("\n\nREAD AFTER DELETE");
		
		//DELETE deleting Authors/publishers cascade deletes associated books
		authDao.delete(10);
		authDao.read().forEach(e -> System.out.println(e.toString()));
		bookDao.read().forEach(e -> System.out.println(e.toString()));
		
		authDao.save();
		pubDao.save();
		bookDao.save();
		} finally {
			
		}
	}

}
