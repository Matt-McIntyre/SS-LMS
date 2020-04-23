package com.ss.lms.models;

import java.io.Serializable;
import java.util.Objects;

import com.ss.lms.dao.KeyGen;

public class Book implements Comparable<Book>, Serializable {

	private static final long serialVersionUID = 3466411109694098935L;
	Integer bookId;
	String bookName;
	Author author;
	Publisher publisher;

	public Book(Integer bookId, String bookName, Author author, Publisher publisher) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
	}

	public Book(String bookId, String bookName, Author author, Publisher publisher) {
		this.bookId = Integer.parseInt(bookId);
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
	}

	public Book(String bookName, Author author, Publisher publisher) {
		this.bookId = KeyGen.getInstance().getKey();
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
	}

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @return the publisher
	 */
	public Publisher getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, bookId, bookName, publisher);
	}

	/**
	 *
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(bookId, other.bookId)
				&& Objects.equals(bookName, other.bookName) && Objects.equals(publisher, other.publisher);
	}
	
	@Override
	public String toString() {
		return "Book [" + bookId + "," + bookName + ", " + author + ", " + publisher
				+ "]";
	}

	@Override
	public int compareTo(Book o) {
		return this.bookId - o.getBookId();
	}
}
