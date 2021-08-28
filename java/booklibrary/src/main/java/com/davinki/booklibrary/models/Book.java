package com.davinki.booklibrary.models;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Book{
	String name;
	String author;
	String category;
	String language;
	Date publicationDate;
	Long isbn;
	String guid;
	boolean taken = false;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Date getPublicationDate() {
		return publicationDate;
	}
	
	public void setPublicationDate() {
		this.publicationDate = new Date();
	}
	
	public Long getISBN() {
		return isbn;
	}
	
	public void setISBN() {
		Random rd = new Random();
		this.isbn = Math.abs(rd.nextLong());
	}
	
	public String getGUID() {
		return guid;
	}

	public void setGUID() {
		UUID newGuid = UUID.randomUUID();
		this.guid = newGuid.toString();
	}
	
	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
}
