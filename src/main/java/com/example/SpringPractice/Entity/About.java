package com.example.SpringPractice.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class About {
	
	
	@Id
	int id;
	String Title;
	String Decription;
	String Image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDecription() {
		return Decription;
	}
	public void setDecription(String decription) {
		Decription = decription;
	}
	
	
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public About() {
		super();
		// TODO Auto-generated constructor stub
	}
	public About(int id, String title, String decription, String image) {
		super();
		this.id = id;
		Title = title;
		Decription = decription;
		Image = image;
	}


}
