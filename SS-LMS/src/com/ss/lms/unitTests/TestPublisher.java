package com.ss.lms.unitTests;

import org.junit.Assert;
import org.junit.Test;

import com.ss.lms.models.Publisher;

public class TestPublisher {

	@Test
	public final void testPublisherIntegerStringString() {
		Publisher a1 = new Publisher(10, "aaa", "bbb");
		Publisher a2 = new Publisher(10, "aaa", "bbb");
		Assert.assertTrue(a1.equals(a2) && a2.equals(a1));
	    Assert.assertTrue(a1.hashCode() == a2.hashCode());
	}

	@Test
	public final void testPublisherStringStringString() {
		Publisher a1 = new Publisher("10", "aaa", "bbb");
		Publisher a2 = new Publisher("10", "aaa", "bbb");
		Assert.assertTrue(a1.equals(a2) && a2.equals(a1));
	    Assert.assertTrue(a1.hashCode() == a2.hashCode());
	}

	@Test
	public final void testPublisherStringString() {
		Publisher a1 = new Publisher(10, "aaa", "bbb");
		Publisher a2 = new Publisher(10, "aaa", "bbb");
		Assert.assertTrue(a1.equals(a2) && a2.equals(a1));
	    Assert.assertTrue(a1.hashCode() == a2.hashCode());
	}

	@Test
	public final void testEqualsObject() {
		Publisher a1 = new Publisher("aaa", "bbb");
		Object o = new Object();
		Assert.assertTrue(a1.equals(a1));
		Assert.assertFalse(a1.equals(o));
	}

	@Test
	public final void testToString() {
		Publisher a1 = new Publisher("aaa", "bbb");
		Assert.assertTrue(a1.toString().getClass().equals("".getClass()));
	}

	@Test
	public final void testCompareTo() {
		Publisher a1 = new Publisher(10, "aaa", "bbb");
		Publisher a2 = new Publisher(11, "aaa", "bbc");
		Assert.assertEquals(a1.compareTo(a2), -1);
	}

	@Test
	public final void testGettersSetters() {
		Publisher a1 = new Publisher("aaa", "bbb");
		a1.setPublisherId(1000);
		a1.setPublisherName("x");
		a1.setAddress("y");
		Assert.assertEquals(a1.getPublisherName(), "x");
		Assert.assertEquals(a1.getAddress(), "y");
		Assert.assertEquals(a1.getPublisherId(), (Integer)1000);
	}
}
