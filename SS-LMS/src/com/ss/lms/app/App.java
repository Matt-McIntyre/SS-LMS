package com.ss.lms.app;

import com.ss.lms.dao.AuthorService;
import com.ss.lms.dao.BookService;
import com.ss.lms.dao.PublisherService;

public class App {

	public static void main(String[] args) {
		AuthorService authDao = new AuthorService();
		PublisherService pubDao = new PublisherService();
		BookService bookDao = new BookService(authDao.getAuthorMap(), pubDao.getPublisherMap());
		authDao.setBookMap(bookDao.getBookMap());
		pubDao.setBookMap(bookDao.getBookMap());		
		
		authDao.loadData();				
		pubDao.loadData();		
		bookDao.loadData();

	}

}
