package com.example.SpringPractice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Subscibe {
	@Id
	int  id;
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
	
	
	
	



	public Subscibe(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}







	
	public Subscibe() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Subscibe [id=" + id + ", email=" + email + "]";
	}
	
	
	

}
