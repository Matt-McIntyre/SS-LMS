package com.ss.lms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ss.lms.models.*;

public class BookService {

	private Map<Integer, Book> books;
	private Map<Integer, Author> authors;
	private Map<Integer, Publisher> publishers;
	private DataFileIO dataFile;

	public BookService(Map<Integer, Author> authors, Map<Integer, Publisher> publishers) {
		this.books = new HashMap<Integer, Book>();
		this.authors = authors;
		this.publishers = publishers;
		this.dataFile = DataFileIO.getInstance();
	}

	public void loadData() {
		dataFile.load("BookFile").stream().map(line -> line.split("\t"))
				.forEach(arr -> create(new Book(Integer.parseInt(arr[0]), arr[1], authors.get(Integer.parseInt(arr[2])),
						publishers.get(Integer.parseInt(arr[3])))));
	}

	public void save() {
		dataFile.save(books.values().stream().map(b -> b.getBookId() + "\t" + b.getBookName() + "\t"
				+ b.getAuthor().getAuthorId() + "\t" + b.getPublisher().getPublisherId()).collect(Collectors.toList()),
				"BookFile");
	}

	public Book findById(int id) {
		return books.get(id);
	}

	public void create(Book book) {
		books.putIfAbsent(book.getBookId(), book);
	}

	public List<Book> read() {
		return books.values().stream().collect(Collectors.toList());
	}

	public void update(int id, String newName, int newAuthorId, int newPublisherId) {
		Book book = findById(id);
		if (book != null) {
			book.setBookName(newName);
			book.setAuthor(authors.get(newAuthorId));
			book.setPublisher(publishers.get(newPublisherId));
		}
	}
	
	public Map<Integer, Book> getBookMap(){
		return this.books;
	}

	public void delete(int id) {
		books.remove(id);
	}

	public void printAll() {
		System.out.println("All Books:");
		books.forEach((k, v) -> System.out.println(v.toString()));
	}
}