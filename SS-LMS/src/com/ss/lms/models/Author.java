package com.ss.lms.models;

import java.io.Serializable;
import java.util.Objects;
import com.ss.lms.dao.KeyGen;

public class Author implements Comparable<Author>, Serializable{

	private static final long serialVersionUID = -6429163661449113581L;
	Integer authorId;
	String authorName;

	public Author(Integer authorId, String authorName) {
		this.authorId = authorId;
		this.authorName = authorName;		
	}
	
	public Author(String authorId, String authorName) {
		this.authorId = Integer.parseInt(authorId);
		this.authorName = authorName;		
	}
	
	public Author(String authorName) {
		this.authorId = KeyGen.getInstance().getKey();
		this.authorName = authorName;
	}		

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		return "Author [ " + authorId + ", " + authorName + " ]";
	}
	
	@Override
	public int compareTo(Author o) {
		return this.authorId - o.getAuthorId();
	}	

	@Override
	public int hashCode() {
		return Objects.hash(authorId, authorName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Author)) {
			return false;
		}
		Author other = (Author) obj;
		return Objects.equals(authorId, other.authorId) && Objects.equals(authorName, other.authorName);
	}
}