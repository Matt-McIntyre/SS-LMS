package com.ss.lms.unitTests;
import org.junit.Assert;
import org.junit.Test;

import com.ss.lms.models.Author;

/**
 * 
 */

/**
 * @author Matt
 *
 */
public class TestAuthor {

	/**
	 * Test method for {@link com.ss.lms.models.Author#Author(java.lang.Integer, java.lang.String)}.
	 */
	@Test
	public final void testAuthorIntegerString() {
		Author a1 = new Author(10, "Test Author");
		Author a2 = new Author(10, "Test Author");
		Assert.assertTrue(a1.equals(a2) && a2.equals(a1));
	    Assert.assertTrue(a1.hashCode() == a2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.lms.models.Author#Author(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAuthorStringString() {
		Author a1 = new Author("10", "Test Author");
		Author a2 = new Author("10", "Test Author");
		Assert.assertTrue(a1.equals(a2) && a2.equals(a1));
	    Assert.assertTrue(a1.hashCode() == a2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.lms.models.Author#Author(java.lang.String)}.
	 */
	@Test
	public final void testAuthorString() {
		Author a1 = new Author("Test Author");
		Author a2 = new Author("Test Author");
		Assert.assertFalse(a1.equals(a2) && a2.equals(a1));
	    Assert.assertFalse(a1.hashCode() == a2.hashCode());
	}

	/**
	 * Test method for {@link com.ss.lms.models.Author#getAuthorId()}.
	 */
	@Test
	public final void testGettersSetters() {
		Author a1 = new Author("Test Author");
		a1.setAuthorId(1000);
		a1.setAuthorName("new name");
		Assert.assertEquals(a1.getAuthorName(), "new name");
		Assert.assertEquals(a1.getAuthorId(), (Integer)1000);
	}

	/**
	 * Test method for {@link com.ss.lms.models.Author#setAuthorId(java.lang.Integer)}.
	 */

	@Test
	public final void testToString() {
		Author a1 = new Author("Test Author");
		Assert.assertTrue(a1.toString().getClass().equals("".getClass()));
	}

	/**
	 * Test method for {@link com.ss.lms.models.Author#compareTo(com.ss.lms.models.Author)}.
	 */
	@Test
	public final void testCompareTo() {
		Author a1 = new Author("10", "Test Author");
		Author a2 = new Author("11", "Test Author");
		Assert.assertEquals(a1.compareTo(a2), -1);
	}

	/**
	 * Test method for {@link com.ss.lms.models.Author#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		Author a1 = new Author("10", "Test Author");
		Object o = new Object();
		Assert.assertTrue(a1.equals(a1));
		Assert.assertFalse(a1.equals(o));
	}

}
