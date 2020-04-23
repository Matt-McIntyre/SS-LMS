package com.ss.lms.models;

import java.io.Serializable;
import java.util.Objects;

import com.ss.lms.dao.KeyGen;

public class Publisher implements Comparable<Publisher>, Serializable{

	private static final long serialVersionUID = 6101777955380974530L;
	Integer publisherId;
	String publisherName;
	String address;

	public Publisher(Integer publisherId, String publisherName, String address) {
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.address = address;
	}
	
	public Publisher(String publisherId, String publisherName, String address) {
		this.publisherId = Integer.parseInt(publisherId);
		this.publisherName = publisherName;
		this.address = address;
	}
	
	public Publisher(String publisherName, String address) {
		this.publisherId = KeyGen.getInstance().getKey();
		this.publisherName = publisherName;
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, publisherId, publisherName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Publisher)) {
			return false;
		}
		Publisher other = (Publisher) obj;
		return Objects.equals(address, other.address) && Objects.equals(publisherId, other.publisherId)
				&& Objects.equals(publisherName, other.publisherName);
	}

	@Override
	public String toString() {
		return "Publisher [" + publisherId + ", " + publisherName + ", " + address
				+ "]";
	}

	@Override
	public int compareTo(Publisher o) {
		return this.publisherId - o.getPublisherId();
	}

	/**
	 * @return the publisherId
	 */
	public Integer getPublisherId() {
		return publisherId;
	}

	/**
	 * @param publisherId the publisherId to set
	 */
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	/**
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * @param publisherName the publisherName to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}