package com.ss.lms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ss.lms.models.*;

public class AuthorService {

	private Map<Integer, Author> authors;
	private Map<Integer, Book> books;
	private DataFileIO dataFile;

	public AuthorService() {
		this.authors = new HashMap<Integer, Author>();
		this.dataFile = DataFileIO.getInstance();
	}

	public void loadData() {
		dataFile.load("AuthFile").stream().map(line -> line.split("\t"))
				.forEach(arr -> create(new Author(Integer.parseInt(arr[0]), arr[1])));
	}

	public void save() {
		dataFile.save(authors.values().stream().map(a -> a.getAuthorId() + "\t" + a.getAuthorName())
				.collect(Collectors.toList()), "AuthFile");
	}

	public Author findById(int id) {
		return authors.get(id);
	}

	public void create(Author author) {
		authors.putIfAbsent(author.getAuthorId(), author);
	}

	public List<Author> read() {
		return authors.values().stream().collect(Collectors.toList());
	}

	public void update(int id, String newName) {
		Author author = findById(id);
		if (author != null)
			author.setAuthorName(newName);
	}

	public void delete(int id) {
		if (authors.containsKey(id)) {
			cascadeDeleteAuthorBooks(authors.get(id));
			authors.remove(id);
		}
	}

	private void cascadeDeleteAuthorBooks(Author author) {
		List<Book> booksToDelete = books.values().stream().filter(book -> book.getAuthor().equals(author))
				.collect(Collectors.toList());
		booksToDelete.forEach(book -> books.remove(book.getBookId()));
	}

	public Map<Integer, Author> getAuthorMap() {
		return this.authors;
	}

	public void setBookMap(Map<Integer, Book> books) {
		this.books = books;
	}

	public void printAll() {
		System.out.println("All Authors:");
		authors.forEach((k, v) -> System.out.println(v.toString()));
	}
}