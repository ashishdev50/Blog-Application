package com.example.SpringPractice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class SendMailForBlogUpload {
@Id
	int id;
	String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SendMailForBlogUpload(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	public SendMailForBlogUpload() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
