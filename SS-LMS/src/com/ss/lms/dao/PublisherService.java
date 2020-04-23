package com.ss.lms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ss.lms.models.*;

public class PublisherService {

	private Map<Integer, Publisher> publishers;
	private Map<Integer, Book> books;
	private DataFileIO dataFile;

	public PublisherService() {
		this.publishers = new HashMap<Integer, Publisher>();
		this.dataFile = DataFileIO.getInstance();
	}

	public void loadData() {
		dataFile.load("PubFile").stream().map(line -> line.split("\t"))
				.forEach(arr -> create(new Publisher(Integer.parseInt(arr[0]), arr[1], arr[2])));
	}

	public void save() {
		dataFile.save(publishers.values().stream()
				.map(p -> p.getPublisherId() + "\t" + p.getPublisherName() + "\t" + p.getAddress())
				.collect(Collectors.toList()), "PubFile");
	}

	public Publisher findById(int id) {
		return publishers.get(id);
	}

	public void create(Publisher author) {
		publishers.putIfAbsent(author.getPublisherId(), author);
	}

	public List<Publisher> read() {
		return publishers.values().stream().collect(Collectors.toList());
	}

	public void update(int id, String newName, String newAddress) {
		Publisher publisher = findById(id);
		if (publisher != null) {
			publisher.setPublisherName(newName);
			publisher.setAddress(newAddress);
		}
	}

	public void delete(int id) {
		if (publishers.containsKey(id)) {
			cascadeDeletePublisherBooks(publishers.get(id));
			publishers.remove(id);
		}
	}

	private void cascadeDeletePublisherBooks(Publisher publisher) {
		List<Book> booksToDelete = books.values().stream().filter(book -> book.getPublisher().equals(publisher)).collect(Collectors.toList());
		booksToDelete.forEach(book -> books.remove(book.getBookId()));
	}

	public void setBookMap(Map<Integer, Book> books) {
		this.books = books;
	}
	
	public Map<Integer, Publisher> getPublisherMap(){
		return this.publishers;
	}

	public void printAll() {
		System.out.println("All Publishers:");
		publishers.forEach((k, v) -> System.out.println(v.toString()));
	}
}