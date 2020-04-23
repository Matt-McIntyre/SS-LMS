/**
 * 
 */
package com.ss.lms.unitTests;

import org.junit.Assert;
import org.junit.Test;

import com.ss.lms.models.Author;
import com.ss.lms.models.Book;
import com.ss.lms.models.Publisher;

public class TestBook {


	@Test
	public final void testBookIntegerStringAuthorPublisher() {
		Publisher p1 = new Publisher(10, "aaa", "bbb");
		Author a1 = new Author(10, "aaa");
		Book b1 = new Book(10, "bbb", a1, p1);
		Book b2 = new Book(10, "bbb", a1, p1);
		Assert.assertTrue(b1.equals(b2) && b2.equals(b1));
	    Assert.assertTrue(b1.hashCode() == b2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.lms.models.Book#Book(java.lang.String, java.lang.String, com.ss.lms.models.Author, com.ss.lms.models.Publisher)}.
	 */
	@Test
	public final void testBookStringStringAuthorPublisher() {
		Publisher p1 = new Publisher(10, "aaa", "bbb");
		Author a1 = new Author(10, "aaa");
		Book b1 = new Book("10", "bbb", a1, p1);
		Book b2 = new Book("10", "bbb", a1, p1);
		Assert.assertTrue(b1.equals(b2) && b2.equals(b1));
	    Assert.assertTrue(b1.hashCode() == b2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.lms.models.Book#Book(java.lang.String, com.ss.lms.models.Author, com.ss.lms.models.Publisher)}.
	 */
	@Test
	public final void testBookStringAuthorPublisher() {
		Publisher p1 = new Publisher(10, "aaa", "bbb");
		Author a1 = new Author(10, "aaa");
		Book b1 = new Book(10, "bbb", a1, p1);
		Book b2 = new Book(10, "bbb", a1, p1);
		Assert.assertTrue(b1.equals(b2) && b2.equals(b1));
	    Assert.assertTrue(b1.hashCode() == b2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.lms.models.Book#getBookId()}.
	 */
	@Test
	public final void testGettersSetters() {
		Publisher p1 = new Publisher(10, "aaa", "bbb");
		Author a1 = new Author(10, "aaa");
		Publisher p2 = new Publisher(11, "aaa", "bbb");
		Author a2 = new Author(11, "aaa");
		Book b1 = new Book("bbb", a1, p1);
		b1.setAuthor(a2);
		b1.setBookId(1000);
		b1.setPublisher(p2);
		b1.setBookName("x");
		Assert.assertEquals(b1.getPublisher(), p2);
		Assert.assertEquals(b1.getAuthor(), a2);
		Assert.assertEquals(b1.getBookName(), "x");
		Assert.assertEquals(b1.getBookId(), (Integer)1000);		
	}


	@Test
	public final void testCompareTo() {
		Publisher p1 = new Publisher(10, "aaa", "bbb");
		Author a1 = new Author(10, "aaa");
		Book b1 = new Book(10, "bbb", a1, p1);
		Book b2 = new Book(11, "bbb", a1, p1);
		Assert.assertEquals(b1.compareTo(b2), -1);
	}

}
